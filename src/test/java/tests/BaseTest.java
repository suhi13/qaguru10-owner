package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelpers.*;

public class BaseTest {

    @BeforeAll
    static void setup() {
        //final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.startMaximized = true;
        Configuration.browser = ConfigHelper.getBrowser();
        Configuration.browserVersion = ConfigHelper.getBrowserVersion();

        /*
        if (ConfigHelper.getSelenoidUrl() != null) {
            Configuration.remote = ConfigHelper.getSelenoidUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
         */
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video_storage") != null)
            attachVideo();

        closeWebDriver();
    }
}