package com.twu.biblioteca.Router;

/**
 * Created by pyan on 8/1/16.
 */
public class RouterContext {
    private RouterState currentState;

    public RouterState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(RouterState currentState) {
        this.currentState = currentState;
    }

    public RouterContext(RouterState currentState)
    {
        this.currentState = currentState;
    }

    public void setNextState(RouterState state)
    {
        currentState = state;
    }
}
