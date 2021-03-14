package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources("classpath:${environment}.properties")
interface WebDriverConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("remote")
    boolean isRemote();

    @Key("selenoid.url")
    String getSelenoidUrl();
}