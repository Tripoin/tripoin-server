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
import com.vaadin.ui.Accordion;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@VaadinView(value = "accordions", cached = true)
public class Accordions extends VerticalLayout implements View {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3709462060904714206L;

	public Accordions() {
        setMargin(true);

        Label h1 = new Label("Accordions");
        h1.addStyleName("h1");
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.setSpacing(true);
        row.setWidth("100%");
        addComponent(row);

        row.addComponent(getAccordion("Normal"));

        Accordion ac = getAccordion("Borderless");
        ac.addStyleName("borderless");
        row.addComponent(ac);

    }

    Accordion getAccordion(String caption) {
        TestIcon testIcon = new TestIcon(0);
        Accordion ac = new Accordion();
        ac.setCaption(caption);
        ac.addTab(new VerticalLayout() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -8605912631949995838L;

			{
                setMargin(true);
                addComponent(new Label(
                        "Fabio vel iudice vincam, sunt in culpa qui officia. Ut enim ad minim veniam, quis nostrud exercitation."));
            }
        }, "First Caption", testIcon.get());
        ac.addTab(new VerticalLayout() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -6707444899417697868L;

			{
                setMargin(true);
                addComponent(new Label(
                        "Gallia est omnis divisa in partes tres, quarum."));
            }
        }, "Second Caption", testIcon.get());
        ac.addTab(new VerticalLayout() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -4054133260368481007L;

			{
                setMargin(true);
                addComponent(new Label(
                        "Nihil hic munitissimus habendi senatus locus, nihil horum? Sed haec quis possit intrepidus aestimare tellus."));
            }
        }, "Third Caption", testIcon.get());
        ac.addTab(new VerticalLayout() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 4008012720196686427L;

			{
                setMargin(true);
                addComponent(new Label(
                        "Inmensae subtilitatis, obscuris et malesuada fames. Quisque ut dolor gravida, placerat libero vel, euismod."));
            }
        }, "Custom Caption Style", testIcon.get()).setStyleName("color1");
        return ac;
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
