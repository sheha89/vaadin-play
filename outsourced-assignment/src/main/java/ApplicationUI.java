import com.vaadin.ui.*;

public class ApplicationUI extends com.vaadin.Application {

    public void init() {
        Window main = new Window("Hello window");
        setMainWindow(main);
        main.addComponent(new Label("Hello World!"));
    }
}