package com.lockarhythm.query;

public class Result {
  private String text;
  private boolean shouldExit;

  public Result(String text, boolean shouldExit) {
    this.text = text;
    this.shouldExit = shouldExit;
  }

  public String getText() {
    return text;
  }

  public boolean shouldExit() {
    return shouldExit;
  }
}