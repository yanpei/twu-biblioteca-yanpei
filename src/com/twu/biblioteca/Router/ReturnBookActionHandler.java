package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

class ReturnBookActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    ReturnBookActionHandler(RouterContext context, BibliotecaService service) {
        this.routerContext = context;
        this.bibliotecaService = service;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        boolean returnSuccess = bibliotecaService.returnBook(userInput);
        routerContext.setNextState(RouterState.MainMenu);
        if (returnSuccess)
        {
            return new RouterMessage(
                    false,
                    false,
                    "Thank you for returning the book.\n\n");
        }
        return new RouterMessage(
                false,
                false,
                "That is not a valid book to return.\n\n");
    }
}
