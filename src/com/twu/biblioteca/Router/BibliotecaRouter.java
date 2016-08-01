package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.NotActiveException;

import static com.twu.biblioteca.Router.RouterState.*;

/**
 * Created by pyan on 8/1/16.
 */
public class BibliotecaRouter {

    private BibliotecaService m_service;
    private RouterContext m_context;

    public BibliotecaRouter(RouterState initialState, BibliotecaService service) {
        m_service = service;
        m_context = new RouterContext(initialState);
    }

    public RouterMessage getRouterMessage(String userInput) {
        return getActionHandler().Handle(userInput);
    }

    private IActionHandler getActionHandler()
    {
        switch (m_context.currentState) {
            case Initialization:
                return new WelcomeActionHandler(m_context,m_service);
            case MainMenu:
                return new MainMenuActionHandler(m_context,m_service);
            case Checkout:
                return new CheckoutActionHandler(m_context,m_service);
            default:
                return new MainMenuActionHandler(m_context,m_service);
        }
    }

}
