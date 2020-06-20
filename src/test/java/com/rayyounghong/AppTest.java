package com.rayyounghong;

import com.rayyounghong.helper.Color;
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
        AppTest.doWhatEver("@BeforeAll executed.");
    }

    @BeforeEach
    void setupThis() {
        AppTest.doWhatEver("@BeforeEach executed.");
    }

    @AfterEach
    void tearThis() {
        AppTest.doWhatEver("@AfterEach executed.");
    }

    @AfterAll
    static void tear() {
        AppTest.doWhatEver("@AfterAll executed.");
    }

    @Test
    void testPrintMessage() {
        AppTest.doWhatEver("Hello, Junit5!");
    }

    /**
     * Output some message to std out.
     *
     * @param message
     *            String output text.
     */
    public static void print(String message) {
        System.out.println(AppTest.TEST_PROMPT + " " + message);
    }

    /**
     * display a colorful block.
     */
    public static void showStartBanner() {
        String banner = "";
        banner += "\n" + BANNER_COLOR_FLAG;
        banner += "\n";
        banner += Color.ANSI_RESET + "\n";
        System.out.println(banner);
    }

    /**
     * display a colorful block.
     */
    public static void showEndBanner() {
        String banner = BANNER_COLOR_FLAG;
        banner += "\n";
        banner += Color.ANSI_RESET + "\n\n";
        System.out.println(banner);
    }

    /**
     * Some methods for avoiding inspection by IDEA.
     */
    public static void doWhatEver() {

    }

    public static void doWhatEver(int var) {
        System.setProperty("TMP_INT", Integer.toString(var));
    }

    public static void doWhatEver(boolean var) {
        System.setProperty("TMP_BOOLEAN", Boolean.toString(var));
    }

    public static void doWhatEver(char var) {
        System.setProperty("TMP_BOOLEAN", Character.toString(var));
    }

    public static void doWhatEver(long var) {
        System.setProperty("TMP_BOOLEAN", Long.toString(var));
    }

    public static void doWhatEver(float var) {
        System.setProperty("TMP_BOOLEAN", Float.toString(var));
    }

    public static void doWhatEver(double var) {
        System.setProperty("TMP_BOOLEAN", Double.toString(var));
    }

    public static void doWhatEver(String var) {
        System.setProperty("TMP_STRING", var);
    }

    public static <T> void doWhatEver(T var) {
        System.setProperty("TMP_T", var.toString());
    }
}
