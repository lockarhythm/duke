package com.lockarhythm.query.echo;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.Response;

public class EchoResponder implements QueryRespondable {
  public Response respondTo(String query) {
    return new Response(query, false);
  }
}
