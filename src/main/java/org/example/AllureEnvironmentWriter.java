package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Class that shows how to create Allure Report environment properties by creating a file
 * environment.properties
 */
public class AllureEnvironmentWriter {

    public static void allureEnvironmentWriter() throws IOException {
        Properties properties = new Properties();
        properties.put("test.prop", "MyValue");

        File allureResultsDir = new File(System.getProperty("user.dir")
                + "/target/allure-results");
        if (!allureResultsDir.exists()) {
            allureResultsDir.mkdirs();
        }
        properties.store(new FileWriter(System.getProperty("user.dir")
                + "/target/allure-results/environment.properties"), "A comment");
    }

}
