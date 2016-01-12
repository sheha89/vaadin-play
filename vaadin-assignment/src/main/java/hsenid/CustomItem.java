package hsenid;

import java.io.Serializable;


public class CustomItem implements Serializable {

    private String name = "";
    private String price = "";

    public CustomItem() {
    }

    public CustomItem(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}