package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

/**
 * Created by pyan on 8/1/16.
 */
public class WelcomeActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    public WelcomeActionHandler(RouterContext context, BibliotecaService service) {
        routerContext = context;
        bibliotecaService = service;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        String welcomeMessage = bibliotecaService.getWelcomeMessage();
        return new RouterMessage(false, welcomeMessage);
    }
}
