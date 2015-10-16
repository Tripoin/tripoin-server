package com.tripoin.web.view.page.user;

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
import com.vaadin.ui.Notification;
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
public class UserAddEdit<DATA> extends VerticalLayout implements View {

	private static final long serialVersionUID = -4592518571070450190L;

	@Autowired
	private IInventoryService inventoryService;

	private BeanItemContainer<UserData> productContainer = new BeanItemContainer<>(UserData.class);

	// VerticalLayout left = new VerticalLayout();
	// FormLayout form = new FormLayout();
	
	private Button edit;
	private Button save;
//	private Button edit;

	@PostConstruct
	public void init() {

	}

	@Override
	public void enter(ViewChangeEvent event) {

	}
	
	public FormLayout formCreateUser(final FormLayout form, final VerticalLayout left, final DATA user) {

		final TextField name = new TextField("Name");
		final TextField email = new TextField("Email");
		final TextField username = new TextField("Username");
		PasswordField pwf = new PasswordField("Password");
		
		final Button cancel = new Button("Cancel", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
				form.removeAllComponents();
				form.setVisible(false);
				left.setVisible(true);

			}
		});

		// final productDatas =
		
		

		
		
		save = new Button("Save", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
				UserData userd = new UserData();
				try {
					userd.setEmail(email.getValue());
					userd.setFullname(name.getValue());
					userd.setUsername(username.getValue());
					inventoryService.saveUser(userd);
				} catch (Exception ex) {
					Notification.show("Data Has Been Save Error", "Desc : "+userd.toString()+ex.getMessage(), Notification.Type.WARNING_MESSAGE);
				}

				// form.removeAllComponents();

				// FormLayout forms = formCreateUser();
				// addComponent(forms);
				// left.setVisible(true);

			}
		});
		edit = new Button("Edit", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
//				UserData userd = new UserData();
				try {
					form.setVisible(true);
					form.removeStyleName("light");
					left.setVisible(false);
					save.setVisible(true);
					edit.setVisible(false);
				} catch (Exception ex) {
					Notification.show("Data Has Been Save Error", "Desc : ", Notification.Type.WARNING_MESSAGE);
				}
			}
		});

		edit.setIcon(FontAwesome.EDIT);
		save.setIcon(FontAwesome.SAVE);
		cancel.setIcon(FontAwesome.REPLY);
		HorizontalLayout footer = new HorizontalLayout();
		footer.setMargin(new MarginInfo(false, false, false, false));
		footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		footer.addComponent(save);
		footer.addComponent(edit);
		footer.addComponent(cancel);
		form.addComponent(footer);
		save.setVisible(false);
		// DATA data = (DATA) user;
		if (user != null) {
			UserData userd = (UserData) user;

			name.setValue(userd.getFullname());
			name.setWidth("50%");
			name.setRequired(true);
			form.addComponent(name);

			username.setValue(userd.getUsername());
			username.setRequired(true);
			form.addComponent(username);

			pwf.setInputPrompt("");
			pwf.setIcon(FontAwesome.LOCK);
			pwf.setRequired(true);
			form.addComponent(pwf);

			email.setValue(userd.getEmail());
			email.setWidth("50%");
			email.setRequired(true);
			form.addComponent(email);

		} else {
			// UserData userd = (UserData) user;
			
			name.setValue("");
			name.setWidth("50%");
			name.setRequired(true);
			form.addComponent(name);

			username.setValue("");
			username.setRequired(true);
			form.addComponent(username);

			pwf.setInputPrompt("");
			pwf.setIcon(FontAwesome.LOCK);
			pwf.setRequired(true);
			form.addComponent(pwf);

			email.setValue("");
			email.setWidth("50%");
			email.setRequired(true);

			form.addComponent(email);

		}
		form.setSizeFull();
		return form;
	}

}
