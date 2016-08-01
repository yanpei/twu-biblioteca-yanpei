package com.twu.biblioteca.Router;

class RouterContext {
    private RouterState currentState;

    RouterState getCurrentState() {
        return currentState;
    }

    RouterContext(RouterState currentState)
    {
        this.currentState = currentState;
    }

    void setNextState(RouterState state)
    {
        currentState = state;
    }
}
