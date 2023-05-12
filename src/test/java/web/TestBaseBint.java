package web;

import config.WebConfigRunner;
import org.junit.jupiter.api.BeforeAll;


public class TestBaseBint {

    @BeforeAll
    static void setUp() {
        new WebConfigRunner().runWebConfig();
    }
}
