package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Resources.MainMenuText;
import java.util.ArrayList;
import java.util.List;

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
                result += "BookName: "+ book.getBookName()
                        +"\t\tAuthor: "+ book.getAuthor()
                        +"\t\tPublished Year: "+ book.getYearPublished()+"\n";
            }
            return new RouterMessage(
                    false,
                    false, "----------Book List--------\n"+result+"---------------------------\n");
        }

        if(userInput.equals("2")){
            if(bibliotecaService.getLoginUser() == null){
                routerContext.setNextState(RouterState.Login);
                return new RouterMessage(false,true,"Please login - split library number and password with " + "\",\"\n");
            }
            routerContext.setNextState(RouterState.Checkout);
            return new RouterMessage(false, true, null);
        }

        if(userInput.equals("3")){
            routerContext.setNextState(RouterState.ReturnBook);
            return new RouterMessage(false, true, null);
        }

        if(userInput.equals("4")){
            List<Movie> allMovies = bibliotecaService.listMovies();
            String result = "";
            for (Movie movie : allMovies) {
                result += "Name: "+ movie.getName()
                        +"\t\tYear: "+ movie.getYear()
                        +"\t\tDirector: "+ movie.getDirector()
                        +"\t\tMovieRanting: "+ (movie.getMovieRanting() > 0 ? movie.getMovieRanting() : "unrated")+"\n";
            }
            return new RouterMessage(
                    false,
                    false, "----------Movie List--------\n"+result+"---------------------------\n");
        }

        if(userInput.equals("5")){
            routerContext.setNextState(RouterState.CheckoutMovie);
            return new RouterMessage(false, true, null);
        }

        if(userInput.equals("6")){
            routerContext.setNextState(RouterState.Login);
            return new RouterMessage(false, true, "Please login - split library number and password with " + "\",\"\n");
        }

        if(userInput.equals("q")){
            return new RouterMessage(true, false, null);
        }

        return new RouterMessage(false, true, "Select a valid option!\n");
    }
}
