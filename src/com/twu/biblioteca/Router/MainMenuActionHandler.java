package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Resources.MainMenuText;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;

/**
 * Created by pyan on 8/1/16.
 */
public class MainMenuActionHandler implements IActionHandler {
    private RouterContext routerContext;
    private BibliotecaService bibliotecaService;

    public MainMenuActionHandler(RouterContext context, BibliotecaService service) {
        routerContext = context;
        bibliotecaService = service;
    }
    

    public RouterMessage Handle(String userInput)
    {
        return new RouterMessage(false, MainMenuText.mainMenuText);
    }
}
