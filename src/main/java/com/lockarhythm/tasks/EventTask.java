package com.lockarhythm.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

final class EventTask extends Task {
  private LocalDate at;
  private String _type = "EVENT";

  public EventTask(String description, String at) {
    super(description);
    this.at = LocalDate.parse(at);
  }

  @Override
  protected String getTaskTypeIcon() {
    return "E";
  }

  @Override
  public String toString() {
    return String.format(
        "%s (at: %s)",
        super.toString(),
        at.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
    );
  }
}
