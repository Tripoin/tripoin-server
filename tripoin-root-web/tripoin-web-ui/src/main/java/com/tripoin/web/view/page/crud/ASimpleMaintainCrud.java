package com.tripoin.web.view.page.crud;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tripoin.web.servlet.VaadinView;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
//import com.jensjansson.pagedtable.PagedTable;
import com.tripoin.core.dto.ProductData;
import com.tripoin.core.dto.UserData;
import com.tripoin.web.service.IInventoryService;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component.Event;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import elemental.css.CSSStyleDeclaration.Cursor;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */

public abstract class ASimpleMaintainCrud<DATA> extends VerticalLayout implements View {

	private static final long serialVersionUID = -4592518571070450190L;

	@Autowired
	private IInventoryService inventoryService;

	private BeanItemContainer<UserData> productContainer = new BeanItemContainer<>(UserData.class);

	protected VerticalLayout left = new VerticalLayout();
	protected FormLayout form = new FormLayout();

	protected DATA datas;

	@Override
	public void enter(ViewChangeEvent event) {

	}

	public HorizontalLayout SimpleTableActionUtil(final DATA entityClass) {
		Label button;
		HorizontalLayout footers2;
		VerticalLayout layout;
		datas = entityClass;
		footers2 = new HorizontalLayout();
		footers2.setMargin(new MarginInfo(false, false, false, false));
		footers2.setSpacing(true);
		footers2.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		// index = i;

		button = new Label("");
		button.addStyleName("with-hand");
		button.setIcon(FontAwesome.EYE);
		// button.addSgetElement().getStyle().setCursor(Cursor.POINTER);
		layout = new VerticalLayout();
		layout.addComponent(button);
		layout.addLayoutClickListener(new LayoutClickListener() {

			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub

				form.setVisible(true);
				FormLayout forms = addEdit(form, left, datas);
				addComponent(forms);
				form.addStyleName("light");
				left.setVisible(false);

			}
		});

		footers2.addComponent(layout);

		button = new Label("");
		button.addStyleName("with-hand");
		button.setIcon(FontAwesome.EDIT);

		// Add some components
		layout = new VerticalLayout();
		layout.addComponent(button);
		layout.addLayoutClickListener(new LayoutClickListener() {

			@Override
			public void layoutClick(LayoutClickEvent event) {
				// TODO Auto-generated method stub

				form.setVisible(true);
				FormLayout forms = addEdit(form, left, datas);
				addComponent(forms);
				form.removeStyleName("light");
				left.setVisible(false);

			}
		});

		footers2.addComponent(layout);

		button = new Label("");
		button.addStyleName("small");
		button.setIcon(FontAwesome.TRASH_O);
		footers2.addComponent(button);
		return footers2;

	}

	public FormLayout addEdit(FormLayout form, VerticalLayout left, DATA datas) {

		return null;
	}
}
