package com.copyright.vaadin;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.addon.ipcforliferay.event.LiferayIPCEvent;
import com.vaadin.addon.ipcforliferay.event.LiferayIPCEventListener;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

/**
 * The Class MainViewWidget.
 * <p/>
 * Copyright (C) 2012
 * <p/>
 * Date: 1/24/12
 *
 * @author Siarhei_Usau
 */
public class MainViewWidget extends VerticalLayout {

    private static final String PDF_PREFIX = "http://dev.vaadin.com/export/8173/doc/trunk/cheatsheet/";

    private Embedded work;

    public MainViewWidget() {
        work = new Embedded();
        work.setMimeType("application/pdf");
        work.setType(Embedded.TYPE_BROWSER);
        work.setWidth("100%");
        work.setHeight("500px");
        work.setImmediate(true);
        work.setReadOnly(true);

        addComponent(work);

        initIPCListener();
    }

    public void initPdfFile(String pdfFileName) {
        try {
            work.setSource(new ExternalResource(PDF_PREFIX + pdfFileName));
        } catch (Exception e) {
            getWindow().showNotification("Could not open PDF: " + pdfFileName + ". Exception: " + e.getMessage());
            e.printStackTrace();
        }
        getWindow().showNotification(pdfFileName);
    }

    /**
     * Possible PDF files: "vaadin-cheatsheet-duplex.pdf", "vaadin-cheatsheet-2.pdf", "vaadin-cheatsheet.pdf".
     */
    private void initIPCListener() {
        LiferayIPC liferayipc = new LiferayIPC();
        addComponent(liferayipc);
        liferayipc.addListener("pdfFileName", new LiferayIPCEventListener() {
            public void eventReceived(LiferayIPCEvent event) {
                String data = event.getData();
                initPdfFile(data);
            }
        });
    }
}
