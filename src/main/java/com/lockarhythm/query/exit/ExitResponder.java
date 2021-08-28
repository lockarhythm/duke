package com.lockarhythm.query.exit;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.Response;

public class ExitResponder implements QueryRespondable {
  public Response respondTo(String query) {
    if (query.equals("bye")) {
      return new Response("Bye. Hope to see you again soon!", true);
    }
    return null;
  }
}
