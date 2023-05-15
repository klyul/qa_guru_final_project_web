package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.TestLoggerHelper.logAndPassSystemProperty;

public class OwnerWebConfigRunner extends WebConfigRunner {

    static DefaultWebConfig config = ConfigFactory.create(DefaultWebConfig.class, System.getProperties());

    @Override
    public void runWebConfig() {

        // Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";

        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.remote = config.getRemoteUrl();
        Configuration.baseUrl = config.getBaseUrl();

        // Конфигурация без указания в джобе:
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }
}