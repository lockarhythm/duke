package com.lockarhythm.ui;

import com.lockarhythm.query.Result;
import java.util.Arrays;
import java.util.Scanner;

/**
 * TerminalUI is an <i>adapter</i> of UI <i>port</i>.
 */
public final class TerminalUI implements UI {
  private static Scanner in = new Scanner(System.in);

  /**
   * nextLine reads the next line from standard input.
   */
  public String nextLine() {
    return in.nextLine();
  }

  /**
   * hasNext returns true if another line is available in standard input.
   */
  public boolean hasNext() {
    return in.hasNext();
  }

  /**
   * print formats the given strings and prints to standard output.
   */
  public void print(String... strings) {
    System.out.println("\t____________________________________________________________");
    for (String s : strings) {
      s = Arrays.stream(s.split("\n")).map(x -> "\t" + x).reduce("", (x, y) -> x + y + "\n");
      System.out.println(s);
    }
    System.out.println("\t____________________________________________________________\n");
  }

  /**
   * print formats the given Result and prints to standard output.
   */
  public void print(Result res) {
    assert res != null;
    print(res.getText());
  }
}
