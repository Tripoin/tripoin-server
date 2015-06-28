package com.tripoin.web.view.crud;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.tripoin.web.component.AttributeExtension;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.ui.TextField;

/**
 * A field for entering numbers. On touch devices, a numeric keyboard is shown
 * instead of the normal one.
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class NumberField extends TextField {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4527572151776264314L;

	public NumberField() {
        // Mark the field as numeric.
        // This affects the virtual keyboard shown on mobile devices.
        AttributeExtension ae = new AttributeExtension();
        ae.extend(this);
        ae.setAttribute("type", "number");

        setConverter(new StringToIntegerConverter() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -4698421667470019381L;

			@Override
            protected NumberFormat getFormat(Locale locale) {
                // do not use a thousands separator, as HTML5 input type
                // number expects a fixed wire/DOM number format regardless
                // of how the browser presents it to the user (which could
                // depend on the browser locale)
                DecimalFormat format = new DecimalFormat();
                format.setMaximumFractionDigits(0);
                format.setDecimalSeparatorAlwaysShown(false);
                format.setParseIntegerOnly(true);
                format.setGroupingUsed(false);
                return format;
            }
        });
    }

    public NumberField(String caption) {
        this();
        setCaption(caption);
    }
}
