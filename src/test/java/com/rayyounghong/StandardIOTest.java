package com.rayyounghong;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author ray
 */
public class StandardIOTest {

    protected static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected static ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    protected static PrintStream originalOut = System.out;
    protected static PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        // Refresh outContent & errContent
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();

        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
