package web;

import config.OwnerWebConfigRunner;
import config.WebConfigRunner;
import helpers.Attach;
import helpers.TestLoggerHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBaseBint {
    static final Logger logger = LoggerFactory.getLogger(TestBaseBint.class);
    @BeforeAll
    static void setUp() {
        new OwnerWebConfigRunner().runWebConfig();
    }
    protected void logException(Exception e) {
        logger.info(e.getMessage());
        e.printStackTrace();
    }


    @AfterEach
    void addAttachments() {

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


