package com.twu.biblioteca.Shell;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Router.BibliotecaRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;

import java.io.*;
import java.util.Scanner;

/**
 * Created by pyan on 7/31/16.
 */
public class BibliotecaShell {
    PrintStream m_outputStream;
    InputStream m_inputStream;

    public BibliotecaShell(PrintStream outputStream, InputStream inputStream)
    {
        m_outputStream = outputStream;
        m_inputStream = inputStream;
    }

    public void Execute()
    {
        BibliotecaRouter router = new BibliotecaRouter(RouterState.Initialization, new BibliotecaService());
        String userInput = null;
        Scanner inputScanner= new Scanner(m_inputStream);

        while (true)
        {
            RouterMessage message = router.getRouterMessage(userInput);
            m_outputStream.println(message.text);
            if (message.exit) { break; }

            userInput = inputScanner.next();
        }
    }
}
