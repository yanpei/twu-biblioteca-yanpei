package com.twu.biblioteca.Shell;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Router.BibliotecaRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.assertEquals;

/**
 * Created by pyan on 7/31/16.
 */
public class BibliotecaShellTest {

    @Test
    public void Should_display_welcome_message_when_current_state_is_Initializing() {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Initialization, new BibliotecaService());
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);
        String s = "Hello, welcome to the Biblioteca!";
        assertEquals(s, routerMessage.text);
    }



}
