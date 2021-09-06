package com.lockarhythm.ui;

import javafx.application.Application;

// From: https://se-education.org/guides/tutorials/javaFxPart1.html
//
/**
 * A launcher class to workaround classpath issues.
 */
public class JavaFXUILauncher {
    public static void main(String[] args) {
        Application.launch(JavaFXUI.class, args);
    }
}
