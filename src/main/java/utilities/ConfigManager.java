package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    public static Properties prop;

    static {
        prop = new Properties();
        try (InputStream input = ConfigManager.class.getResourceAsStream("/config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


//        private static ConfigManager instance = new ConfigManager();
//        private Properties prop;
//
//        private ConfigManager() {
//            prop = new Properties();
//            try (InputStream input = getClass().getResourceAsStream("/config.properties")) {
//                prop.load(input);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        public static ConfigManager getInstance() {
//            return instance;
//        }
//
//        public Properties getProperties() {
//            return prop;
//        }


}