package config;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelpers.attachAsText;
import static helpers.AttachmentHelpers.attachPageSource;
import static helpers.AttachmentHelpers.attachScreenshot;
import static helpers.AttachmentHelpers.attachVideo;
import static helpers.AttachmentHelpers.getConsoleLogs;

import com.codeborne.selenide.Configuration;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.qameta.allure.selenide.AllureSelenide;

public class BaseTest {

    @BeforeAll
    static void setup() {
        final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.startMaximized = true;
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        if (config.getSelenoidUrl() != null) {
            Configuration.remote = config.getSelenoidUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
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

