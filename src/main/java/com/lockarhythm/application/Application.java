package com.lockarhythm.application;

import com.lockarhythm.responders.QueryRespondable;
import com.lockarhythm.responders.Response;
import com.lockarhythm.responders.addlist.AddListResponder;
import com.lockarhythm.responders.exit.ExitResponder;
import com.lockarhythm.responders.markasdone.MarkAsDoneResponder;
import com.lockarhythm.tasks.TaskList;
import com.lockarhythm.ui.UI;

public class Application {
  static String logo =
      " \t____        _        \n"
          + "\t|  _ \\ _   _| | _____ \n"
          + "\t| | | | | | | |/ / _ \\\n"
          + "\t| |_| | |_| |   <  __/\n"
          + "\t|____/ \\__,_|_|\\_\\___|\n";

  static TaskList list = new TaskList();

  static QueryRespondable[] responders = {
    new ExitResponder(), new MarkAsDoneResponder(list), new AddListResponder(list),
  };

  private static Response getResponse(String query) {
    Response res = null;
    for (QueryRespondable responder : responders) {
      res = responder.respondTo(query);
      if (res != null) {
        return res;
      }
    }
    return res;
  }

  public static void run(UI ui) {
    Response response;

    ui.print("Hello I'm\n" + logo, "What can I do for you?");

    do {
      response = getResponse(ui.nextLine());
      ui.print(response);
    } while (ui.hasNext() && !response.shouldExit());
  }
}
