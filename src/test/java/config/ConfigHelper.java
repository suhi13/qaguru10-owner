package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static WebDriverConfig getConfig() {
       if (System.getProperty("environment") == null) System.setProperty("environment", "local"); // test, preprod
        return ConfigFactory.newInstance().create(WebDriverConfig.class, System.getProperties());
    }

    public static String getBrowser() {
        return getConfig().getBrowser();
    }

    public static String  getBrowserVersion() {
        return getConfig().getBrowserVersion();
    }
    public static boolean isRemote() {
        return getConfig().isRemote();
    }
    public static String getSelenoidUrl(){
        return getConfig().getSelenoidUrl();
    }
}