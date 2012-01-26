package com.copyright.vaadin;

import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import org.apache.commons.lang.BooleanUtils;

/**
 * The Class MainMenuWidget.
 * <p/>
 * Copyright (C) 2012
 * <p/>
 * Date: 1/26/12
 *
 * @author Siarhei_Usau
 */
public class MainMenuWidget extends VerticalLayout implements ItemClickEvent.ItemClickListener {

    public static final Object ITEM_PROPERTY_NAME = "name";
    public static final Object ITEM_PROPERTY_IS_PARENT = "isParent";

    private LiferayIPC liferayipc;

    public MainMenuWidget() {
        // Create the Tree,a dd to layout
        Tree tree = new Tree("Select PDF file:");
        addComponent(tree);

        // Contents from a (prefilled example) hierarchical container:
        tree.setContainerDataSource(getHierarchicalContainer());

        // Add Valuechangelistener and Actionhandler
        tree.addListener(this);

        // Set tree to show the 'name' property as caption for items
        tree.setItemCaptionPropertyId(ITEM_PROPERTY_NAME);
        tree.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);

        // Cause valueChange immediately when the user selects
        tree.setImmediate(true);

        // Expand whole tree
        for (Object id : tree.rootItemIds()) {
            tree.expandItemsRecursively(id);
        }

        liferayipc = new LiferayIPC();
        addComponent(liferayipc);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        // Indicate which modifier keys are pressed
        switch (event.getButton()) {
            case ItemClickEvent.BUTTON_LEFT:
                handleSelection(event.getItem());
                break;
            case ItemClickEvent.BUTTON_MIDDLE:
                handleSelection(event.getItem());
                break;
            case ItemClickEvent.BUTTON_RIGHT:
                handleSelection(event.getItem());
                break;
        }
    }

    private void handleSelection(Item item) {
        // If something is selected from the tree
        String itemValue = item.getItemProperty(ITEM_PROPERTY_NAME).getValue().toString();
        Boolean isParent = (Boolean) item.getItemProperty(ITEM_PROPERTY_IS_PARENT).getValue();

        if (BooleanUtils.isFalse(isParent)) {
            liferayipc.sendEvent("pdfFileName", itemValue);
        }
    }

    private HierarchicalContainer getHierarchicalContainer() {
        HierarchicalContainer container = new HierarchicalContainer();
        container.addContainerProperty(ITEM_PROPERTY_NAME, String.class, null);
        container.addContainerProperty(ITEM_PROPERTY_IS_PARENT, Boolean.class, null);

        buildItem(container, "PDF files:", 0, 0, true);
        buildItem(container, "vaadin-cheatsheet-duplex.pdf", 0, 1, false);
        buildItem(container, "vaadin-cheatsheet-2.pdf", 0, 2, false);
        buildItem(container, "vaadin-cheatsheet.pdf", 0, 3, false);

        return container;
    }

    private void buildItem(HierarchicalContainer container, String name, int parentPosition, int position,
                           boolean parent) {
        Item item = container.addItem(position);
        item.getItemProperty(ITEM_PROPERTY_NAME).setValue(name);
        item.getItemProperty(ITEM_PROPERTY_IS_PARENT).setValue(parent);
        container.setChildrenAllowed(position, parent);
        if (!parent) {
            container.setParent(position, parentPosition);
        }
    }
}
