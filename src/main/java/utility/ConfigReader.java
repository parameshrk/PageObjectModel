package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("Config/InvoiePlane.properties");

        // 2. create the object of properties class
        Properties prop = new Properties();

        //3. load the properties with file object
        prop.load(fis);

        return prop;
    }

    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }

    public static String getUsername() throws IOException {
        return getLoadedPropertiesObject().getProperty("username");
    }

    public static String getPassword() throws IOException {
        return getLoadedPropertiesObject().getProperty("password");
    }

    public static String getDbUrl() throws IOException {
            return getLoadedPropertiesObject().getProperty("dbUrl");
        }

        public static String getDbUser() throws IOException {
            return getLoadedPropertiesObject().getProperty("dbUser");
        }

        public static String getDbPassword() throws IOException {
            return getLoadedPropertiesObject().getProperty("dbPass");
        }

    }
