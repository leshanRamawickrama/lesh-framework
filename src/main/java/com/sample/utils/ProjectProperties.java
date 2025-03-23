package com.sample.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ProjectProperties {

        private ProjectProperties() {
        }

        private static LoggerUtil logger = new LoggerUtil(ProjectProperties.class);

        private static Map<String, String> readProperties() {
            Map<String, String> propertiesMap = new HashMap<>();
            try {
                InputStream ins = ProjectProperties.class.getClassLoader().getResourceAsStream("properties/Project.properties");
                InputStreamReader reader = new InputStreamReader(ins);
                Properties p = new Properties();
                p.load(reader);
                p.entrySet().forEach(x -> propertiesMap.put(x.getKey().toString(), x.getValue().toString()));
                reader.close();
                ins.close();
            } catch (IOException e) {
                logger.logError(e);
            }
            return propertiesMap;
        }

        public static String getProperty(String key) {
            return System.getProperty(key, readProperties().get(key));
        }

        public static void setProperty(String key, String value) {
            System.setProperty(key, value);
        }


}
