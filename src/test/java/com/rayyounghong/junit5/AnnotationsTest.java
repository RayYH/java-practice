package com.rayyounghong.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ray
 * @see <a href="https://devqa.io/junit-5-annotations/">JUnit 5 Annotations With Examples</a>
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations">Annotations</a>
 */
@Tag("Annotations")
public class AnnotationsTest {

    private static int index = 1;

    /*
     * This annotation denotes that a method is a test method.
     * Note this annotation does not take any attributes.
     */
    @Test
    void helloJunit5() {
        assertEquals(3, 1 + 2);
    }

    /*
     * Parameterized tests make it possible to run a test multiple times with different arguments.
     *
     * In addition, you must declare at least one source that will provide the arguments for each
     * invocation and then consume the arguments in the test method.
     */
    @ParameterizedTest
    @ValueSource(strings = {"apple", "make", "cache"})
    void palindromes(String word) {
        String endsFlag = "e";
        assertTrue(word.endsWith(endsFlag));
    }

    /*
     * JUnit 5 has the ability to repeat a test a specified number of times simply by annotating
     * a method with @RepeatedTest and specifying the total number of repetitions desired.
     */
    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("RepeatingTest")
    void customDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() +
            " --> " + repInfo.getCurrentRepetition()
        );

        assertEquals(repInfo.getCurrentRepetition(), index++);
    }

    /*
     * Test classes and test methods can declare custom display names that will be displayed
     * by test runners and test reports.
     */
    @Test
    @DisplayName("Custom test name")
    void testWithDisplayName() {
    }

    @Test
    @DisplayName("Print test name")
    void printDisplayName(TestInfo testInfo) {
        doSomething(); // for avoiding inspection
        System.out.println(testInfo.getDisplayName());
    }

    /*
     * The @Disabled annotation is used to disable or skip tests at class or method level.
     */
    @Disabled
    void doSomething() {
    }
}
