package com.twu.biblioteca.Shell;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Router.BibliotecaRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;

import java.io.*;
import java.util.Scanner;

public class BibliotecaShell {
    private PrintStream m_outputStream;
    private InputStream m_inputStream;

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
            if(message.getText() != null){
                m_outputStream.println(message.getText());
            }
            if (message.getExit()) { break; }
            if(message.isWaitingInput()) {
                userInput = inputScanner.nextLine();
            } else {
                userInput = null;
            }
        }
    }
}
