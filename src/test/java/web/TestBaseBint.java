package web;

import config.OwnerWebConfigRunner;
import config.WebConfigRunner;
import org.junit.jupiter.api.BeforeAll;


public class TestBaseBint {

    @BeforeAll
    static void setUp() {
        new OwnerWebConfigRunner().runWebConfig();
    }
}
