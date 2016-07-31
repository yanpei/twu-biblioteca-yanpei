package com.twu.biblioteca;

import com.twu.biblioteca.Shell.BibliotecaShell;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;

    @org.junit.Before
    public void setUp() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void should_welcome_when_customer_start_the_application() {
        BibliotecaShell.welcomeCusotme();
        String s = "Hello, welcome to the Biblioteca!\n";
        assertEquals(s, bytes.toString());
    }
}
