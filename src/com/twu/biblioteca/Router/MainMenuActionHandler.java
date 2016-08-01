package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Resources.MainMenuText;
import java.util.ArrayList;

class MainMenuActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    MainMenuActionHandler(RouterContext context, BibliotecaService service) {
        routerContext = context;
        bibliotecaService = service;
    }

    public RouterMessage Handle(String userInput)
    {
        if(userInput == null){
            return new RouterMessage(false, true, MainMenuText.getMainMenuText());
        }

        if(userInput.equals("1")){
            ArrayList<Book> listBooks = bibliotecaService.listBooks();
            String result = "";
            for (Book book : listBooks) {
                result += book.toString();
            }
            return new RouterMessage(
                    false,
                    true, "----------Book List--------\n"+result+"\n---------------------------\n");
        }

        if(userInput.equals("2")){
            routerContext.setNextState(RouterState.Checkout);
            return new RouterMessage(false, true, null);
        }

        if(userInput.equals("3")){
            routerContext.setNextState(RouterState.ReturnBook);
            return new RouterMessage(false, true, null);
        }

        if(userInput.equals("q")){
            return new RouterMessage(true, false, null);
        }

        return new RouterMessage(false, true, "Select a valid option!\n");
    }
}
