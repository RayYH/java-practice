package com.rayyounghong.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * @author ray
 * @date 2020/6/20
 * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names">Display
 * Names</a>
 */
public class DisplayNameDemo {

    /*
     * Test classes and test methods can declare custom display names via @DisplayName — with
     * spaces, special characters, and even emojis — that will be displayed in test reports
     * and by test runners and IDEs.
     */

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }
}
