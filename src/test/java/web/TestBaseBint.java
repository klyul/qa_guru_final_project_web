package web;

import config.OwnerWebConfigRunner;
import config.WebConfigRunner;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestBaseBint {
    protected void logException(Exception e) {
        logger.info(e.getMessage());
        e.printStackTrace();
    }
    @BeforeAll
    static void setUp() {
        new OwnerWebConfigRunner().runWebConfig();
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


}
