package com.lockarhythm.application;

import com.lockarhythm.query.SimpleQueryInterpreter;
import com.lockarhythm.tasks.TaskList;
import com.lockarhythm.ui.TerminalUI;

public class TerminalDuke {
  public static void main(String[] args) {
    Application.run(new TerminalUI(), new SimpleQueryInterpreter(new TaskList()));
  }
}
