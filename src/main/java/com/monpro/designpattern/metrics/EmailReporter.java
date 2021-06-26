package com.monpro.designpattern.metrics;

import com.google.gson.Gson;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class EmailReporter {

  private MetricsStorage metricsStorage;
  private EmailSender emailSender;
  private static final List<String> receiverAddressList = new ArrayList<>();
  private static final Gson gson = new Gson();

  @Inject
  public void setMetricsStorage(MetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  @Inject
  public void setEmailReporter(EmailSender emailSender) {
    this.emailSender = emailSender;
  }

  public void addReceiverAddress(String address) {
    receiverAddressList.add(address);
  }

  public void startDailyReport() {
    final Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    Timer timer = new Timer();
    timer.schedule(
        new TimerTask() {
          @Override
          public void run() {
            final long durationInMills = 86400L * 1000;
            final long endTimeInMills = System.currentTimeMillis();
            final Map<String, RequestStats> stats =
                MetricHelper.getCalculateStats(metricsStorage, durationInMills, endTimeInMills);
            log.info("Going to send email: {}, {}, {}", gson.toJson(stats), emailSender, receiverAddressList);
          }
        },
        calendar.getTime(),
        86400L * 1000);
  }
}
