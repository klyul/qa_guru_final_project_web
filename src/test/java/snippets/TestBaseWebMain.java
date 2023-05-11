package snippets;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.OwnerWebConfigRunner;
import helpers.Attach;
import helpers.TestLoggerHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.TestSelenideConfigLogger.logSelenideMainConfigValues;


public class TestBaseWebMain {

    static final Logger logger = LoggerFactory.getLogger(TestBaseWebMain.class);

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new OwnerWebConfigRunner().runWebConfig();
        logSelenideMainConfigValues();
    }

    protected void logException(Exception e) {
        logger.info(e.getMessage());
        e.printStackTrace();
    }

    @AfterEach
    void addAttachments() {
        Attach.attachAsText("My custom log", TestLoggerHelper.getCustomLogs());

        // TODO: Доделать чтобы не сыпалось исключений с dryRun независимо от вариантов запуска.

        try {
            Attach.screenshotAs("Last screen");
        } catch (Exception e) {
            logException(e);
        }

        try {
            Attach.pageSource();
        } catch (Exception e) {
            logException(e);
        }

        try {
            Attach.browserConsoleLogs();
        } catch (Exception e) {
            logException(e);
        }

        try {
            Attach.addVideo();
        } catch (Exception e) {
            logException(e);
        }

    }

}