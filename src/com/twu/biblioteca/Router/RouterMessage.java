package com.twu.biblioteca.Router;

public class RouterMessage {
    public RouterMessage(Boolean exit, boolean isWaitingInput, String text)
    {
        this.exit = exit;
        this.isWaitingInput = isWaitingInput;
        this.text = text;
    }

    private Boolean exit;
    private boolean isWaitingInput;
    private String text;

    public Boolean getExit() {
        return exit;
    }

    public boolean isWaitingInput() {
        return isWaitingInput;
    }

    public String getText() {
        return text;
    }
}
