package hsenid;

import java.util.Arrays;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.BaseTheme;

@SuppressWarnings("serial")
public class CustomFormLayout extends VerticalLayout {

    CustomItem customItem;
    int itemCountOnRender;

    public CustomFormLayout(final Table table) {

        itemCountOnRender = table.size();

        System.out.println(itemCountOnRender);

        customItem = new CustomItem(); // a item POJO
        BeanItem<CustomItem> beanItem = new BeanItem<CustomItem>(customItem); // item from
        // POJO

        // Create the Form
        final Form itemForm = new Form();
        itemForm.setCaption("Custom Item Form");
        itemForm.setWriteThrough(false); // we want explicit 'apply'
        itemForm.setInvalidCommitted(false); // no invalid values in datamodel

        // FieldFactory for customizing the fields and adding validators
        itemForm.setFormFieldFactory(new CustomItemFieldFactory());
        itemForm.setItemDataSource(beanItem); // bind to POJO via BeanItem

        // Determines which properties are shown, and in which order:
        itemForm.setVisibleItemProperties(Arrays.asList(new String[]{
                "name", "price"}));

        // Add form to layout
        addComponent(itemForm);

        // The cancel / apply buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button discardChanges = new Button("Discard changes",
                new Button.ClickListener() {
                    public void buttonClick(ClickEvent event) {
                        itemForm.discard();
                    }
                });
        discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
        buttons.addComponent(discardChanges);
        buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);


        Button apply = new Button("Add", new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                try {
                    itemForm.commit();
                    itemCountOnRender++;
                    table.addItem(new Object[]{customItem.getName(), customItem.getPrice()}, new Integer(itemCountOnRender));
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }
            }
        });
        buttons.addComponent(apply);
        itemForm.getFooter().addComponent(buttons);
        itemForm.getFooter().setMargin(false, false, true, true);

    }

}

/*

public class MyVaadinApplication extends Application
{
    private Window window;

    @Override
    public void init()
    {
        window = new Window("My Vaadin Application");
        setMainWindow(window);
        Button button = new Button("Click Me");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                window.addComponent(new Label("Thank you for clicking"));
            }
        });
        window.addComponent(button);

    }

}
*/
