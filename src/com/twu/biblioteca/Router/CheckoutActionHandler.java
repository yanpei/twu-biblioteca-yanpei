package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Resources.MainMenuText;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by pyan on 8/1/16.
 */
public class CheckoutActionHandler implements IActionHandler {

    RouterContext routerContext;
    BibliotecaService bibliotecaService;

    public CheckoutActionHandler(RouterContext routerContext, BibliotecaService service){
        this.routerContext = routerContext;
        this.bibliotecaService = service;
    }

    public RouterMessage Handle(String userInput)
    {
        boolean checkoutSuccess = bibliotecaService.checkoutBook(userInput);
        if (checkoutSuccess)
        {
            routerContext.setNextState(RouterState.MainMenu);
            return new RouterMessage(
                    false,
                    "Thank you! Enjoy the book\n\n" + MainMenuText.mainMenuText);
        }
        return new RouterMessage(
                false,
                "That book is not available.\n\n" + MainMenuText.mainMenuText);
    }

}
