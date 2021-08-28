package com.lockarhythm.query;

import com.lockarhythm.responders.Response;

public interface QueryInterpreter {
  public Response interpret(String query); // TODO: rename to QueryResult
}
