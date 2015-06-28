package com.tripoin.web.component;

import com.vaadin.shared.JavaScriptExtensionState;

import java.util.HashMap;

/**
 * Shared state class for {@link AttributeExtension} communication from server
 * to client.
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class AttributeExtensionState extends JavaScriptExtensionState {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3353488077081453174L;
	public HashMap<String, String> attributes = new HashMap<String, String>();
}
