package com.sample;

import com.sample.configs.AppConfig;
import com.sample.gui.CustomFormLayout;
import com.sample.gui.CustomTableLayout;
import com.vaadin.Application;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@ComponentScan(basePackages = "com.sample")
public class MyVaadinApplication  extends Application
{
    private Window window;
    private Table table;

    CustomFormLayout customFormLayout;

    CustomTableLayout customTableLayout;

    private static ApplicationContext applicationContext;

    @Override
    public void init()
    {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        table = new Table();
        window = new Window("My Vaadin Application");
        customTableLayout = new CustomTableLayout(table);
        customFormLayout = new CustomFormLayout(table);
        setMainWindow(window);
        window.addComponent(customFormLayout);
        window.addComponent(customTableLayout);

    }

}