package helpers;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class TestSelenideConfigLogger {

    Logger logger = LoggerFactory.getLogger(TestSelenideConfigLogger.class);

    public static TestSelenideConfigLogger getTestSelenideConfigLogger() {
        return new TestSelenideConfigLogger();
    }

    public static void logSelenideMainConfigValues() {
        getTestSelenideConfigLogger()
                .logBrowserName()
                .logBrowserSize()
                .logBrowserVersion()
                .logBrowserBaseUrl()
                .logBrowserRemote();
    }

    public TestSelenideConfigLogger logBrowserName() {
        logger.info("Selenide browser name: " + Configuration.browser);
        return this;
    }

    public TestSelenideConfigLogger logBrowserSize() {
        logger.info("Selenide browser size: " + Configuration.browserSize);
        return this;
    }

    public TestSelenideConfigLogger logBrowserVersion() {
        logger.info("Selenide browser version: " + Configuration.browserVersion);
        return this;
    }

    public TestSelenideConfigLogger logBrowserBaseUrl() {
        logger.info("Selenide base URL: " + Configuration.baseUrl);
        return this;
    }

    public TestSelenideConfigLogger logBrowserRemote() {
        logger.info("Selenide remote: " + Configuration.remote);
        return this;
    }

}