package com.lockarhythm.application;

import com.lockarhythm.query.QueryInterpreter;
import com.lockarhythm.query.QueryResult;
import com.lockarhythm.ui.UI;

public class Application {
  static String logo =
      " \t____        _        \n"
          + "\t|  _ \\ _   _| | _____ \n"
          + "\t| | | | | | | |/ / _ \\\n"
          + "\t| |_| | |_| |   <  __/\n"
          + "\t|____/ \\__,_|_|\\_\\___|\n";

  public static void run(UI ui, QueryInterpreter q) {
    QueryResult response;

    ui.print("Hello I'm\n" + logo, "What can I do for you?");

    do {
      response = q.interpret(ui.nextLine());
      ui.print(response);
    } while (ui.hasNext() && !response.shouldExit());
  }
}
