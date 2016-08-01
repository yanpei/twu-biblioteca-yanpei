package com.twu.biblioteca.Router;

/**
 * Created by pyan on 8/1/16.
 */
public class RouterMessage {
    public RouterMessage(Boolean exit, String text)
    {
        this.exit = exit;
        this.text = text;
    }

    public Boolean exit;
    public String text;
}
