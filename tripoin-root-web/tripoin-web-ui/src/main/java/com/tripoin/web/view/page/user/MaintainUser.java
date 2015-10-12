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
@VaadinView(value = "maintainUser", cached = true)
public class MaintainUser<DATA> extends ASimpleMaintainCrud<DATA> implements View {

	private static final long serialVersionUID = -4592518571070450190L;

	@Autowired
	private IInventoryService inventoryService;

	private BeanItemContainer<UserData> productContainer = new BeanItemContainer<>(UserData.class);

	
	UserAddEdit productAddEdit = new UserAddEdit();
	
	
	@PostConstruct
	public void init() {
		setSpacing(true);
		setMargin(true);
		Label title = new Label("User");
		title.addStyleName("h1");
		addComponent(title);

		
		addComponent(left);
		form.setMargin(false);
		form.setWidth("800px");
		addComponent(form);

		Button create = new Button("Create", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
//				 UI.getCurrent().getNavigator().navigateTo("maintainProduct");
				
				form.setVisible(true);
				FormLayout forms = productAddEdit.formCreateUser(form,left,null);
				addComponent(forms);
				left.setVisible(false);
			}
		});

		create.setIcon(FontAwesome.PLUS);
		create.addStyleName("light");

		HorizontalLayout footer = new HorizontalLayout();
		footer.setMargin(new MarginInfo(false, false, true, false));
		footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		footer.addComponent(create);
		left.addComponent(footer);

		// LIST USER
		
		Table table = getListTableUser("List User");
		HorizontalLayout footer3 = new HorizontalLayout();
		footer3.setMargin(new MarginInfo(false, false, false, false));
		footer3.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		footer3.addComponent(table);
		left.addComponent(footer3);
		

		
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	
	public Table getListTableUser(String text) {
		VerticalLayout tableLayout = new VerticalLayout();
		tableLayout.setSizeUndefined();
		Table table = new Table(text);
		
		final List<UserData> productDatas = inventoryService.getAllUser();
		

		table.addContainerProperty("username", String.class, null);
		table.addContainerProperty("action", HorizontalLayout.class, null);
		int index;
		Object object[] ;
		for (final UserData userdata : productDatas) {
			
			HorizontalLayout footers2 = SimpleTableActionUtil((DATA) userdata);
			object = new Object[2];
			object[0] = userdata.getUsername();
			object[1] = footers2;
			
			table.addItem(object, userdata);

		}

		table.setPageLength(15);
		table.setHeight("300px");
		table.setWidth("800px");
		return table;

	}
	
	
	@Override
	public FormLayout addEdit(FormLayout form,VerticalLayout left,DATA datas){
		return productAddEdit.formCreateUser(form, left, datas);
	}

}
