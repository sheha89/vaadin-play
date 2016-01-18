package com.sample.gui;

import com.vaadin.data.Item;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

public class CustomItemFieldFactory extends DefaultFieldFactory {

    private static final String COMMON_FIELD_WIDTH = "12em";

    public CustomItemFieldFactory() {
    }

    @Override
    public Field createField(Item item, Object propertyId,
                             Component uiContext) {
        Field f;
        // Use the super class to create a suitable field base on the
        // property type.
        f = super.createField(item, propertyId, uiContext);

        if ("name".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter a Name");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "First Name must be 3-30 characters", 3, 20, false));
        } else if ("price".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter a Price");
            tf.setWidth(COMMON_FIELD_WIDTH);
            tf.addValidator(new StringLengthValidator(
                    "Price should be a decimal", 1, 4, false));
        }
        return f;
    }

}