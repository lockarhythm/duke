package com.lockarhythm.query.markasdone;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.Response;
import com.lockarhythm.tasks.Task;
import com.lockarhythm.tasks.TaskList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkAsDoneResponder implements QueryRespondable {
  private TaskList list;
  Pattern pattern = Pattern.compile("^done (\\d+)");

  public MarkAsDoneResponder(TaskList list) {
    this.list = list;
  }

  public Response respondTo(String query) {
    Matcher matcher = pattern.matcher(query);
    if (matcher.find()) {
      int i = Integer.parseInt(matcher.group(1));
      if (i > 0 && i <= list.size()) {
        Task task = list.markAsDone(i - 1);
        return new Response("Nice! I've marked this task as done:\n\t" + task.toString(), false);
      }
      return new Response(
          String.format("Item %d is not on the list. I cannot mark it as done!", i), false);
    }
    return null;
  }
}
