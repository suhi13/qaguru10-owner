package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")

public
interface WebDriverConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("selenoid.url")
    String getSelenoidUrl();
}
//gradle test -Denvironment=local
//gradle test -Denvironment=remote
