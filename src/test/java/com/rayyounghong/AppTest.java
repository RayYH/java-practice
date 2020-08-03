package com.rayyounghong;

import com.rayyounghong.helper.DisableInspection;
import org.junit.jupiter.api.*;

/**
 * This class shows some basic junit annotations.
 *
 * <ul>
 * <li>{@code @Tag} Declare tags for filtering tests.</li>
 * <li>{@code @Test} Denotes a test method.</li>
 * <li>{@code @Nested} Denotes that the annotated class is a nested, non-static test class.</li>
 * <li>{@code @Disable} Used to disable a test class or test method.</li>
 * <li>{@code @AfterAll} Denotes that the annotated method should be executed after all test methods.</li>
 * <li>{@code @BeforeAll} Denotes that the annotated method should be executed before all test methods.</li>
 * <li>{@code @AfterEach} Denotes that the annotated method should be executed after each test method.</li>
 * <li>{@code @BeforeEach} Denotes that the annotated method should be executed before each test method.</li>
 * <li>{@code @ExtendWith} Register custom extensions.</li>
 * <li>{@code @DisplayName} Declares a custom display name for the test class or test method.</li>
 * </ul>
 * <a href="https://www.journaldev.com/20834/junit5-tutorial"></a>
 */
public class AppTest {
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
