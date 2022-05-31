package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = System.getProperty("user.dir") + "/configs/Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUserNameFor(String user) {
        if (user.equalsIgnoreCase("user1_id")) {
            String username = properties.getProperty("user1_id");
            if (username != null) return username;
            else throw new RuntimeException("user not specified in the Configuration.properties file.");
        } else {
            String username = properties.getProperty("user2_id");
            if (username != null) return username;
            else throw new RuntimeException("user not specified in the Configuration.properties file.");
        }
    }

    public String getPasswordFor(String user) {
        if (user.equalsIgnoreCase("user1_password")) {
            String username = properties.getProperty("user1_password");
            if (username != null) return username;
            else throw new RuntimeException("Password not specified in the Configuration.properties file.");
        } else {
            String username = properties.getProperty("user2_password");
            if (username != null) return username;
            else throw new RuntimeException("Password not specified in the Configuration.properties file.");
        }
    }

    public String getBoardName() {
        String boardname = properties.getProperty("boardName");
        if (boardname != null) return boardname;
        else throw new RuntimeException("BoardName not specified in the Configuration.properties file.");
    }

    public String getExpectedImageFilePath() {
        String expectedImagePath = properties.getProperty("expectedImagePath");
        if (expectedImagePath != null) return expectedImagePath;
        else throw new RuntimeException("ExpectedImagePath not specified in the Configuration.properties file.");
    }

    public String getActualImageFilePath() {
        String actualImagePath = properties.getProperty("actualImagePath");
        if (actualImagePath != null) return actualImagePath;
        else throw new RuntimeException("ActualImagePath not specified in the Configuration.properties file.");
    }
}
