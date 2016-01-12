package hsenid;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class CustomTableLayout extends VerticalLayout {

    public CustomTableLayout(final Table table) {

        table.setCaption("Custom Item Details");
        addComponent(table);

        table.setWidth("100%");

        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Price",  String.class,  null);

        table.addItem(new Object[] {
                "Nicolaus","Copernicus"}, new Integer(1));
        table.addItem(new Object[]{
                "Tycho", "Brahe"}, new Integer(2));
        table.addItem(new Object[] {
                "Giordano","Bruno"}, new Integer(3));


    }
}