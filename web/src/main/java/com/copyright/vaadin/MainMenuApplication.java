package com.copyright.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * The Class MainMenuApplication.
 * <p/>
 * Copyright (C) 2012
 * <p/>
 * Date: 1/25/12
 *
 * @author Siarhei_Usau
 */
public class MainMenuApplication extends Application {

    @Override
    public void init() {
        Window mainWindow = new Window();
        mainWindow.setContent(new MainMenuWidget());
        setMainWindow(mainWindow);
    }
}
