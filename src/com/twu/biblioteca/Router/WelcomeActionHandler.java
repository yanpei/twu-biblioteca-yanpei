package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

class WelcomeActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    WelcomeActionHandler(RouterContext context, BibliotecaService service) {
        routerContext = context;
        bibliotecaService = service;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        String welcomeMessage = bibliotecaService.getWelcomeMessage();
        routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage(false,false,welcomeMessage);
    }
}
