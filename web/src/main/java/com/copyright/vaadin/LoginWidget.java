package com.copyright.vaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * The Class LoginWidget.
 * <p/>
 * Copyright (C) 2012
 * <p/>
 * Date: 1/24/12
 *
 * @author Siarhei_Usau
 */
public class LoginWidget extends VerticalLayout {

    public LoginWidget() {
        setMargin(true);

        // Create the custom layout and set it as a component in
        // the current layout
        CustomLayout custom = new CustomLayout("../../layouts/main_layout");
        addComponent(custom);

        // Create components and bind them to the location tags
        // in the custom layout.
        TextField username = new TextField();
        custom.addComponent(username, "username");

        TextField password = new TextField();
        custom.addComponent(password, "password");

        Button ok = new Button("Login");
        custom.addComponent(ok, "okbutton");
    }

}
