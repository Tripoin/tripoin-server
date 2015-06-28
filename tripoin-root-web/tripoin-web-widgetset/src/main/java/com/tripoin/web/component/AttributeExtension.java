package com.tripoin.web.component;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.ui.TextField;

/**
 * A JavaScript extension for adding arbitrary HTML attributes for components.
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@JavaScript("attribute_extension_connector.js")
public class AttributeExtension extends AbstractJavaScriptExtension {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4113218060333010627L;

	public void extend(TextField target) {
        super.extend(target);
    }

    @Override
    protected AttributeExtensionState getState() {
        return (AttributeExtensionState) super.getState();
    }

    public void setAttribute(String attribute, String value) {
        getState().attributes.put(attribute, value);
    }
}
