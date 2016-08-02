package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

/**
 * Created by pyan on 8/2/16.
 */
public class LoginActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    public LoginActionHandler(RouterContext m_context, BibliotecaService m_service) {
        this.routerContext = m_context;
        this.bibliotecaService = m_service;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        bibliotecaService.login(userInput);
        routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage(false,false,null);
    }
}
