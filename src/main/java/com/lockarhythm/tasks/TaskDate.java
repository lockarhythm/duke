package com.lockarhythm.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

class TaskDate implements Serializable {
  private LocalDate d;

  public TaskDate(String s) {
    d = LocalDate.parse(s);
  }

  @Override
  public String toString() {
    return d.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
  }
}
