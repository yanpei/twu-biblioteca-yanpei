package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Resources.MainMenuText;

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
                    true, "Thank you! Enjoy the book\n\n" + MainMenuText.getMainMenuText());
        }
        return new RouterMessage(
                false,
                true, "That book is not available.\n\n" + MainMenuText.getMainMenuText());
    }

}
