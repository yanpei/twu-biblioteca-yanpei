package com.twu.biblioteca.Router;

/**
 * Created by pyan on 8/1/16.
 */
public class RouterContext {
    private RouterState m_currentState;

    public RouterContext(RouterState currentState)
    {
        m_currentState = currentState;
    }

    public void SetNextState(RouterState state)
    {
        m_currentState = state;
    }

    public RouterState CurrentState = m_currentState;
}
