package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class AllureEnvironmentWriter {

    public static void allureEnvironmentWriter()  {
        Properties properties = new Properties();
        properties.put("test.prop", "MyValue");

        File allureResultsDir = new File(System.getProperty("user.dir")
                + "/target/allure-results");
        if (!allureResultsDir.exists()) {
            allureResultsDir.mkdirs();
        }
        try {
            properties.store(new FileWriter(System.getProperty("user.dir")
                    + "/target/allure-results/environment.properties"), "A comment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
