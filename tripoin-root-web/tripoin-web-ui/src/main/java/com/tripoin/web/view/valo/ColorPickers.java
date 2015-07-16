/*
 * Copyright 2000-2013 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.tripoin.web.view.valo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripoin.web.servlet.VaadinView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.AbstractColorPicker.PopupStyle;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@VaadinView(value = "colorpickers", cached = true)
public class ColorPickers extends VerticalLayout implements View {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4214567364263639809L;

	public ColorPickers() {
        setMargin(true);

        Label h1 = new Label("Color Pickers");
        h1.addStyleName("h1");
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName("wrapping");
        row.setSpacing(true);
        addComponent(row);

        TestIcon testIcon = new TestIcon(40);

        ColorPicker cp = new ColorPicker();
        cp.setDefaultCaptionEnabled(true);
        cp.setIcon(testIcon.get());
        cp.setColor(new Color(138, 73, 115));
        row.addComponent(cp);

        cp = new ColorPicker();
        cp.setPopupStyle(PopupStyle.POPUP_SIMPLE);
        cp.setTextfieldVisibility(true);
        row.addComponent(cp);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
