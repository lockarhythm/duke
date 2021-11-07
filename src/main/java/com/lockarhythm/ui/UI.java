package com.lockarhythm.ui;

import com.lockarhythm.query.Result;

/**
 * UI is a <i>port</i>. An example adapter is the TerminalUI.
 */
public interface UI {
  /**
   * nextLine returns the next line from the input.
   */
  public String nextLine();

  /**
   * hasNext returns true if there are more line(s) to be consumed in the next call to nextLine. Returns false otherwise.
   */
  public boolean hasNext();

  /**
   * print should print the given strings to the output.
   */
  public void print(String... strings);

  /**
   * print is a helper function to print Results to output.
   */
  public void print(Result res);
}
