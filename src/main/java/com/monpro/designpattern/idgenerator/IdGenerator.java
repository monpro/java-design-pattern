package com.monpro.designpattern.idgenerator;

public interface IdGenerator {
  String generate() throws IdGenerationFailureException;
}
