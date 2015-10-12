package com.tripoin.web.view.page.product;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tripoin.web.servlet.VaadinView;
import com.tripoin.web.view.page.crud.ASimpleMaintainCrud;
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
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
@Scope("prototype")
public class ProductAddEdit<DATA> extends VerticalLayout implements View {

	private static final long serialVersionUID = -4592518571070450190L;

	@Autowired
	private IInventoryService inventoryService;

	private BeanItemContainer<UserData> productContainer = new BeanItemContainer<>(UserData.class);

//	VerticalLayout left = new VerticalLayout();
	//FormLayout form = new FormLayout();
	
	
	@PostConstruct
	public void init() {
		

		
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	public FormLayout formCreateUser(final FormLayout form,final VerticalLayout left,DATA user) {
		final Button cancel = new Button("Cancel", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
				form.removeAllComponents();
				form.setVisible(false);
				left.setVisible(true);
				
			}
		});
	
		final Button save = new Button("Save", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
//				form.removeAllComponents();
				
//				FormLayout forms = formCreateUser();
//				addComponent(forms);
//				left.setVisible(true);
				
			}
		});

		
		save.setIcon(FontAwesome.SAVE);
		cancel.setIcon(FontAwesome.REPLY);
		HorizontalLayout footer = new HorizontalLayout();
		footer.setMargin(new MarginInfo(false, false, false, false));
		footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		footer.addComponent(save);
		footer.addComponent(cancel);
		form.addComponent(footer);
//		DATA data = (DATA) user;
		UserData userd = (UserData) user;
		
		TextField name = new TextField("Name");
		name.setValue(userd.getUsername());
		name.setWidth("50%");
		name.setRequired(true);
		form.addComponent(name);

		TextField username = new TextField("Username");
		username.setValue("");
		username.setRequired(true);
		form.addComponent(username);

		PasswordField pwf = new PasswordField("Password");
		pwf.setInputPrompt("");
		pwf.setIcon(FontAwesome.LOCK);
		pwf.setRequired(true);
		form.addComponent(pwf);

		TextField email = new TextField("Email");
		email.setValue("");
		email.setWidth("50%");
		email.setRequired(true);
		form.addComponent(email);

		return form;
	}

}
