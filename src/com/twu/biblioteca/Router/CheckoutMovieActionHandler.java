package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

public class CheckoutMovieActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    public CheckoutMovieActionHandler(RouterContext m_context, BibliotecaService m_service) {
        this.routerContext = m_context;
        this.bibliotecaService = m_service;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        bibliotecaService.checkoutMovie(userInput);
        routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage(false,false,null);
    }
}
