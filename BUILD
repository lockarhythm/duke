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

java_binary(
    name = "TerminalDuke",
    srcs = glob([
        "src/main/java/com/lockarhythm/**/*.java",
    ]),
    deps = ["@maven//:org_apache_commons_commons_lang3"]
)

java_binary(
    name = "JavaFXUILauncher",
    srcs = glob(["src/main/java/com/lockarhythm/ui/JavaFXUI*.java"]),
    deps = [
        ":javafx_mac_deps"
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
