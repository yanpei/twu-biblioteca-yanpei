package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

/**
 * Created by pyan on 8/1/16.
 */
public class WrongOptionActionHandler implements IActionHandler {
    public WrongOptionActionHandler(RouterContext m_context, BibliotecaService m_service) {
    }

    @Override
    public RouterMessage Handle(String userInput) {
        return null;
    }
}
