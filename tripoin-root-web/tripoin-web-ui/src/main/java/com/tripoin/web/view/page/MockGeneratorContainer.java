package com.tripoin.web.view.page;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Container.Hierarchical;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Resource;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class MockGeneratorContainer {

    public static final String CAPTION_PROPERTY = "caption";
    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String ICON_PROPERTY = "icon";
    public static final String INDEX_PROPERTY = "index";
    
    @SuppressWarnings("unchecked")
    public static Container generateContainer(final int size, final boolean hierarchical) {
        final BaseIcon baseIcon = new BaseIcon(90);
        final IndexedContainer container = hierarchical ? new HierarchicalContainer() : new IndexedContainer();
        final StringGenerator sg = new StringGenerator();
        container.addContainerProperty(CAPTION_PROPERTY, String.class, null);
        container.addContainerProperty(ICON_PROPERTY, Resource.class, null);
        container.addContainerProperty(INDEX_PROPERTY, Integer.class, null);
        container.addContainerProperty(DESCRIPTION_PROPERTY, String.class, null);
        for (int i = 1; i < size + 1; i++) {
            final Item item = container.addItem(i);
            item.getItemProperty(CAPTION_PROPERTY).setValue(sg.nextString(true) + " " + sg.nextString(false));
            item.getItemProperty(INDEX_PROPERTY).setValue(i);
            item.getItemProperty(DESCRIPTION_PROPERTY).setValue(sg.nextString(true) + " " + sg.nextString(false) + " " + sg.nextString(false));
            item.getItemProperty(ICON_PROPERTY).setValue(baseIcon.get());
        }
        container.getItem(container.getIdByIndex(0)).getItemProperty(ICON_PROPERTY).setValue(baseIcon.get());

        if (hierarchical) {
            for (int i = 1; i < size + 1; i++) {
                for (int j = 1; j < 5; j++) {
                    final String id = i + " -> " + j;
                    Item child = container.addItem(id);
                    child.getItemProperty(CAPTION_PROPERTY).setValue(sg.nextString(true) + " " + sg.nextString(false));
                    child.getItemProperty(ICON_PROPERTY).setValue(baseIcon.get());
                    // ((Hierarchical) container).setChildrenAllowed(id, false);
                    ((Hierarchical) container).setParent(id, i);

                    for (int k = 1; k < 6; k++) {
                        final String id2 = id + " -> " + k;
                        child = container.addItem(id2);
                        child.getItemProperty(CAPTION_PROPERTY).setValue(sg.nextString(true) + " " + sg.nextString(false));
                        child.getItemProperty(ICON_PROPERTY).setValue(baseIcon.get());
                        // ((Hierarchical) container)
                        // .setChildrenAllowed(id, false);
                        ((Hierarchical) container).setParent(id2, id);

                        for (int l = 1; l < 5; l++) {
                            final String id3 = id2 + " -> " + l;
                            child = container.addItem(id3);
                            child.getItemProperty(CAPTION_PROPERTY).setValue(sg.nextString(true) + " " + sg.nextString(false));
                            child.getItemProperty(ICON_PROPERTY).setValue(baseIcon.get());
                            // ((Hierarchical) container)
                            // .setChildrenAllowed(id, false);
                            ((Hierarchical) container).setParent(id3, id2);
                        }
                    }
                }
            }
        }
        return container;
    }
    
}
