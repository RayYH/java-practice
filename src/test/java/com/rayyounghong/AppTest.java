package com.rayyounghong;

import com.rayyounghong.helper.Color;
import com.rayyounghong.helper.DisableInspection;
import org.junit.jupiter.api.*;

public class AppTest {
    /*
     * see: https://www.journaldev.com/20834/junit5-tutorial
     *
     * @Test        Denotes a test method
     * @DisplayName	Declares a custom display name for the test class or test method
     * @BeforeEach	Denotes that the annotated method should be executed before each test method
     * @AfterEach	Denotes that the annotated method should be executed after each test method
     * @BeforeAll	Denotes that the annotated method should be executed before all test methods
     * @AfterAll	Denotes that the annotated method should be executed after all test methods
     * @Disable	    Used to disable a test class or test method
     * @Nested	    Denotes that the annotated class is a nested, non-static test class
     * @Tag	        Declare tags for filtering tests
     * @ExtendWith	Register custom extensions
     */

    public static final String TEST_PROMPT = '[' + Color.ANSI_YELLOW + "TEST" + Color.ANSI_RESET + ']';

    public static final String BANNER_COLOR_FLAG = Color.ANSI_GREEN_BACKGROUND;

    @BeforeAll
    static void setup() {
        DisableInspection.doWhatEver("@BeforeAll executed.");
    }

    @BeforeEach
    void setupThis() {
        DisableInspection.doWhatEver("@BeforeEach executed.");
    }

    @AfterEach
    void tearThis() {
        DisableInspection.doWhatEver("@AfterEach executed.");
    }

    @AfterAll
    static void tear() {
        DisableInspection.doWhatEver("@AfterAll executed.");
    }

    @Test
    void testPrintMessage() {
        DisableInspection.doWhatEver("Hello, Junit5!");
    }
}
