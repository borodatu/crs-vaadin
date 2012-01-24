package com.copyright.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * The Class CRSApplication.
 * <p/>
 * Copyright (C) 2012
 * <p/>
 * Date: 1/23/12
 *
 * @author Siarhei_Usau
 */
public class CRSApplication extends Application {

    @Override
    public void init() {
        Window mainWindow = new Window();
        mainWindow.setContent(new LoginWidget());
        setMainWindow(mainWindow);
    }
}
