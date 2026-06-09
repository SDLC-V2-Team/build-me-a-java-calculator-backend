package com.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTests {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testHappyPathAddition() {
        String input = "2 + 3\nexit\n";
        System.setIn(new NoCloseInputStream(input));
        Main.main(new String[0]);
        String output = testOut.toString();
        assertTrue(output.contains("5"));
    }

    @Test
    void testDivisionByZeroShowsError() {
        String input = "5 / 0\nexit\n";
        System.setIn(new NoCloseInputStream(input));
        Main.main(new String[0]);
        String output = testOut.toString();
        assertTrue(output.contains("Error:"));
    }

    @Test
    void testIntegerResultFormattedWithoutDecimal() {
        String input = "4 / 2\nexit\n";
        System.setIn(new NoCloseInputStream(input));
        Main.main(new String[0]);
        String output = testOut.toString();
        // Output should be "2", not "2.0"
        assertTrue(output.contains("2"));
        assertFalse(output.contains("2.0"));
    }

    @Test
    void testInvalidFormatTooManyTokensShowsErrorMessage() {
        String input = "2 + 3 + 4\nexit\n";
        System.setIn(new NoCloseInputStream(input));
        Main.main(new String[0]);
        String output = testOut.toString();
        assertTrue(output.contains("Invalid format"));
    }

    @Test
    void testInvalidNumberShowsErrorMessage() {
        String input = "a + 2\nexit\n";
        System.setIn(new NoCloseInputStream(input));
        Main.main(new String[0]);
        String output = testOut.toString();
        assertTrue(output.contains("Invalid number"));
    }

    /**
     * Wraps a byte array input stream so that closing it does nothing.
     * This preserves System.in for subsequent tests.
     */
    private static class NoCloseInputStream extends InputStream {
        private final ByteArrayInputStream delegate;

        NoCloseInputStream(String data) {
            this.delegate = new ByteArrayInputStream(data.getBytes());
        }

        @Override
        public int read() {
            return delegate.read();
        }

        @Override
        public int read(byte[] b, int off, int len) {
            return delegate.read(b, off, len);
        }

        @Override
        public void close() throws IOException {
            // do not close the underlying stream
        }
    }
}