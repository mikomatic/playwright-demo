
# Playwright Demo

This a pet project to test [Playwright Java](https://github.com/microsoft/playwright-java) features.

It comes with integration with the [Allure Framework](https://github.com/allure-framework/allure-maven) for basic reporting
## Run Locally

Clone the project

```bash
  git clone git@github.com:mikomatic/playwright-demo.git
```

Go to the project directory

```bash
  cd playwright-demo
```

Run maven and allure plugin

```bash
  # "clean test" & "allure:report" goals can be done separately
  PLAYWRIGHT_JAVA_SRC="./src/test/java"
  mvn clean test allure:report
```

Playwright tests should be launched and report generated at `target/site/allure-maven-plugin`.

You can also serve the report directly via the command
```bash
  # "clean test" & "allure:serve" goals can be done separately
  PLAYWRIGHT_JAVA_SRC="./src/test/java"
  mvn clean test allure:serve
```

### Trace viewer

A specific test `TracingTest.java` showcases how to record a trace.
It should be available by running the command: 

```bash
mvn exec:java -e "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=show-trace target/trace.zip"`
```

Or by uploading the file `target/trace.zip` to https://trace.playwright.dev (only Chrome/Chromium compatible it seems)

## Demo

The generated report is also available as a github page https://mikomatic.github.io/playwright-demo/

