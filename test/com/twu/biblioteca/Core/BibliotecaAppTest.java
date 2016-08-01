package com.twu.biblioteca.Core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void Should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        String welcomeResult = new BibliotecaApp().getWelcomeMessage();
        assertEquals("Hello, welcome to the Biblioteca!",welcomeResult);
    }


}
