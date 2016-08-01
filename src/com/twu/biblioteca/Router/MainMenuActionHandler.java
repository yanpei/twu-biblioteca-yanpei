package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Resources.MainMenuText;
import java.util.ArrayList;

public class MainMenuActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    public MainMenuActionHandler(RouterContext context, BibliotecaService service) {
        routerContext = context;
        bibliotecaService = service;
    }

    public RouterMessage Handle(String userInput)
    {
        if(userInput == null){
            return new RouterMessage(false,MainMenuText.mainMenuText);
        }else if(userInput.equals("1")){
            ArrayList<Book> listBooks = bibliotecaService.listBooks();
            String result = "";
            for (Book book : listBooks) {
                result += book.toString();
            }
            return new RouterMessage(
                    false,
                    result+"\n---------------------------\n");
        }else if(userInput.equals("2")){
            routerContext.setNextState(RouterState.Checkout);
            return new RouterMessage(false,null);
        }else if(userInput.equals("3")){
            routerContext.setNextState(RouterState.ReturnBook);
            return new RouterMessage(false, null);
        }else if(userInput.equals("q")){
            return new RouterMessage(true, null);
        }else {
            return new RouterMessage(false,"Select a valid option!\n" + MainMenuText.mainMenuText);
        }

    }
}
