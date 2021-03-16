package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:local.properties",
        "classpath:${environment}.properties"
})
public
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