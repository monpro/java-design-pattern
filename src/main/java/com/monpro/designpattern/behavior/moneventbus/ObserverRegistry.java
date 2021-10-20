package com.monpro.designpattern.behavior.moneventbus;

import com.google.common.base.Preconditions;
import com.monpro.designpattern.behavior.basic.Observer;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {

  private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry =
      new ConcurrentHashMap<>();

  /** find all methods annotated with @Subscribe within clazz.
   *
   * @param clazz A object passed in run-time;
   * @return A list of methods annotated with @Subscribe
   */
  private List<Method> findAnnotatedMethods(final Class<?> clazz) {
    final List<Method> annotatedMethods = new ArrayList<>();
    for (final Method declaredMethod : clazz.getDeclaredMethods()) {
      final Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
      Preconditions.checkArgument(
          parameterTypes.length == 1,
          "Method %s has @Subscribe annotation has %s parameters. Should only have 1",
          declaredMethod,
          parameterTypes.length);
      annotatedMethods.add(declaredMethod);
    }
    return annotatedMethods;
  }

  /** Find relationship from observer eventType to list of ObserverAction.
   *
   * @param observer A observer instance.
   * @return A map from eventType to ObserverAction.
   */
  private Map<Class<?>, Collection<ObserverAction>> findObserverActions(final Object observer) {
    final Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
    final Class<?> clazz = observer.getClass();
    findAnnotatedMethods(clazz).forEach(method -> {
      final Class<?>[] parameterTypes = method.getParameterTypes();
      final Class<?> eventType = parameterTypes[0];
      observerActions.putIfAbsent(eventType, new ArrayList<>());
      observerActions.get(eventType).add(new ObserverAction(observer, method));
    });
    return observerActions;
  }

  public List<ObserverAction> findMatchedObservedActions(final Object event) {
    final List<ObserverAction> matchedObservedActions = new ArrayList<>();
    final Class<?> eventType = event.getClass();
    for(final Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry: registry.entrySet()) {
      final Class<?> entryEventType = entry.getKey();
      final CopyOnWriteArraySet<ObserverAction> entryActions = entry.getValue();
      if(entryEventType.isAssignableFrom(entryEventType)) {
        matchedObservedActions.addAll(entryActions);
      }
    }
    return matchedObservedActions;
  }

  public void register(final Object observer) {
    final Map<Class<?>, Collection<ObserverAction>> observerActions = findObserverActions(observer);
    for( Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
      final Class<?> entryEventType = entry.getKey();
      final Collection<ObserverAction> entryActions = entry.getValue();
      CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(entryEventType);
      if (registeredEventActions == null) {
        registeredEventActions = new CopyOnWriteArraySet<>();
      }
      registeredEventActions.addAll(entryActions);
      registry.put(entryEventType, registeredEventActions);
    }
  }
}
