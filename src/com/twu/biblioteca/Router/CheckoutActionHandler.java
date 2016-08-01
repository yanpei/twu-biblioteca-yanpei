package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

class CheckoutActionHandler implements IActionHandler {

    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    CheckoutActionHandler(RouterContext routerContext, BibliotecaService service){
        this.routerContext = routerContext;
        this.bibliotecaService = service;
    }

    public RouterMessage Handle(String userInput)
    {
        boolean checkoutSuccess = bibliotecaService.checkoutBook(userInput);
        routerContext.setNextState(RouterState.MainMenu);
        if (checkoutSuccess)
        {
            return new RouterMessage(
                    false,
                    false, "Thank you! Enjoy the book\n\n");
        }
        return new RouterMessage(
                false,
                false, "That book is not available.\n\n");
    }

}
