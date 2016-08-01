package com.twu.biblioteca.Router;

/**
 * Created by pyan on 8/1/16.
 */
public class RouterContext {
    public RouterState currentState;

    public RouterContext(RouterState currentState)
    {
        this.currentState = currentState;
    }

    public void SetNextState(RouterState state)
    {
        currentState = state;
    }
}
