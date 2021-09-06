load("@rules_java//java:defs.bzl", "java_binary", "java_test")

java_library(
    name = "javafx_mac_deps",
    exports = [
        "@maven//:org_openjfx_javafx_controls_mac",
        "@maven//:org_openjfx_javafx_graphics_mac",
        "@maven//:org_openjfx_javafx_base_mac",
        "@maven//:org_openjfx_javafx_fxml_mac"
    ],
)

java_library(
    name = "javafx_controllers",
    srcs = glob([
        "src/main/java/com/lockarhythm/ui/MainWindow.java", # TODO: move these javafx stuff into own package.
    ]),
    deps = [":javafx_mac_deps"]
)

java_binary(
    name = "TerminalDuke",
    srcs = glob([
        "src/main/java/com/lockarhythm/**/*.java",
    ]),
    deps = ["@maven//:org_apache_commons_commons_lang3"]
)

java_binary(
    name = "JavaFXUILauncher",
    srcs = glob([
        "src/main/java/com/lockarhythm/ui/JavaFXUI*.java",
        #"src/main/java/com/lockarhythm/ui/MainWindow.java", # TODO: move these javafx stuff into own package.
        ]),
    resources = [
        "src/main/resources/view/MainWindow.fxml",
    ],
    deps = [
        ":javafx_mac_deps"
    ],
    runtime_deps = [
        ":javafx_controllers",
    ],
)

[
  java_test(
      name = class_name,
      size = "small",
      srcs = glob([
          "src/test/java/com/lockarhythm/**/*.java",
          "src/main/java/com/lockarhythm/**/*.java",
      ]),
  )
  for class_name in [
      "TestTerminalDuke",
      "TestEchoResponder",
      "TestExitResponder",
      "TestListResponder",
      "TestMarkAsDoneResponder",
      "TestTodoTask",
      "TestTaskList",
  ]
]
