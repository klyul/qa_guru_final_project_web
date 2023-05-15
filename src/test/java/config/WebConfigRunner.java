package config;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.Objects;

@SuppressWarnings("all")
public class WebConfigRunner {
    public void runWebConfig() {
        // Улучшает загрузку страниц если какой-то ресурс проблемно тянется
        Configuration.pageLoadStrategy = "eager";

        // Change to true if you need to hold browser open
        Configuration.holdBrowserOpen = false;

        Configuration.browserSize = "1920x1080";

        // Change to true if you need remote execution
        Configuration.remote = System.getProperty("remoteURL");

        Configuration.baseUrl = "https://bellintegrator.ru";

        if (!Objects.isNull(Configuration.remote)) {
            // Конфигурация без указания в джобе:
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;

        }

    }
}
