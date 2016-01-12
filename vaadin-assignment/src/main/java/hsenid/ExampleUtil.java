package hsenid;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

public final class ExampleUtil {

    private static final String[] iso3166 = new String[]{"merc", "12",
            "jaguar", "65", "land rover", "1117", "bmw", "14",
            "subaru", "65", "nissan", "86", "toyota", "76"};

    public static final Object iso3166_PROPERTY_NAME = "name";
    public static final Object iso3166_PROPERTY_SHORT = "short";

    @Deprecated
    public static IndexedContainer getStaticContainer() {
        return getContainer();
    }

    public static IndexedContainer getContainer() {
        IndexedContainer c = new IndexedContainer();
        fillContainer(c);
        return c;
    }

    private static void fillContainer(IndexedContainer container) {
        container.addContainerProperty(iso3166_PROPERTY_NAME, String.class,
                null);
        container.addContainerProperty(iso3166_PROPERTY_SHORT, String.class,
                null);

        for (int i = 0; i < iso3166.length; i++) {
            String name = iso3166[i++];
            String id = iso3166[i];
            Item item = container.addItem(id);
            item.getItemProperty(iso3166_PROPERTY_NAME).setValue(name);
            item.getItemProperty(iso3166_PROPERTY_SHORT).setValue(id);

        }
        container.sort(new Object[]{iso3166_PROPERTY_NAME},
                new boolean[]{true});
    }

}
