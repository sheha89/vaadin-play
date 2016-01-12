package hsenid;

import com.vaadin.Application;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication  extends Application
{
    private Window window;
    private Table table;
    private CustomFormLayout customFormLayout;
    private CustomTableLayout customTableLayout;

    @Override
    public void init()
    {
        table = new Table();
        window = new Window("My Vaadin Application");
        customTableLayout = new CustomTableLayout(table);
        customFormLayout = new CustomFormLayout(table);
        setMainWindow(window);
        window.addComponent(customFormLayout);
        window.addComponent(customTableLayout);

    }

}