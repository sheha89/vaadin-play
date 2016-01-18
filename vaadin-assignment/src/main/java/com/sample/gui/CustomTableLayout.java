package com.sample.gui;

import com.sample.model.CustomItem;
import com.sample.service.CustomItemService;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Component
public class CustomTableLayout extends VerticalLayout {

    @Autowired
    CustomItemService customItemService;

    List<CustomItem> itemList = new ArrayList<>();

    public CustomTableLayout(final Table table) {

        System.out.println("#");
        System.out.println("#");
        System.out.println("#");
        System.out.println(customItemService);

        itemList = customItemService.findAllCustomItems();

        table.setCaption("Custom Item Details");
        addComponent(table);

        table.setWidth("100%");

        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Price", String.class, null);

        final int[] itemIndex = {0};

        itemList.forEach(item -> table.addItem(new Object[]{
                item.getName(), item.getPrice()}, ++itemIndex[0]));

//        table.addItem(new Object[]{
//                "Nicolaus", "Copernicus"}, new Integer(1));
//        table.addItem(new Object[]{
//                "Tycho", "Brahe"}, new Integer(2));
//        table.addItem(new Object[]{
//                "Giordano", "Bruno"}, new Integer(3));


    }

}