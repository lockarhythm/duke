package com.lockarhythm.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

final class DeadlineTask extends Task {
  private LocalDate by;
  private String _type = "DEADLINE";

  public DeadlineTask(String description, String by) {
    super(description);
    this.by = LocalDate.parse(by);
  }

  @Override
  protected String getTaskTypeIcon() {
    return "D";
  }

  @Override
  public String toString() {
    return String.format(
        "%s (by: %s)",
        super.toString(),
        by.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
    );
  }
}
