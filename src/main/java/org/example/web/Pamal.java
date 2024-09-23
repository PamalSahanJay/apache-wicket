package org.example.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class Pamal extends WebPage {
    public Pamal() {
        add(new Label("message", "Welcome to Pamal's Page!"));
    }
}
