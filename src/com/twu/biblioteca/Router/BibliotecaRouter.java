package com.twu.biblioteca.Router;

import com.twu.biblioteca.Core.BibliotecaService;

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
        return new WelcomeActionHandler(m_context,m_service);
    }

}
