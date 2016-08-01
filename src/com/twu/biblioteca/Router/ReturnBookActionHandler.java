package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Resources.MainMenuText;

public class ReturnBookActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;
    public ReturnBookActionHandler(RouterContext context, BibliotecaService service) {
        this.routerContext = context;
        this.bibliotecaService = service;
    }

    @Override
    public RouterMessage Handle(String userInput) {
        boolean returnSuccess = bibliotecaService.returnBook(userInput);
        if (returnSuccess)
        {
            routerContext.setNextState(RouterState.MainMenu);
            return new RouterMessage(
                    false,
                    "Thank you for returning the book.\n\n" + MainMenuText.mainMenuText);
        }
        return new RouterMessage(false, null);
    }
}
