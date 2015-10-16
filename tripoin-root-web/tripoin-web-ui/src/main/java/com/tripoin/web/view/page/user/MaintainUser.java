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
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
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
@VaadinView(value = "maintainUser", cached = true)
public class MaintainUser<DATA> extends ASimpleMaintainCrud<DATA> implements View {

	private static final long serialVersionUID = -4592518571070450190L;

	@Autowired
	private IInventoryService inventoryService;

	private BeanItemContainer<UserData> productContainer = new BeanItemContainer<>(UserData.class);

	UserAddEdit productAddEdit = new UserAddEdit();

	private String selectedColumn;
	Button delete;
	DATA tesdata;

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
				// UI.getCurrent().getNavigator().navigateTo("maintainProduct");

				form.setVisible(true);
				FormLayout forms = productAddEdit.formCreateUser(form, left, null);
				addComponent(forms);
				left.setVisible(false);
			}
		});

		create.setIcon(FontAwesome.PLUS);
		create.addStyleName("light");

		delete = new Button("Delete", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;

			@Override
			public void buttonClick(ClickEvent event) {
				// UI.getCurrent().getNavigator().navigateTo("maintainProduct");

				form.setVisible(true);
				FormLayout forms = productAddEdit.formCreateUser(form, left, null);
				addComponent(forms);
				left.setVisible(false);
			}
		});

		delete.setIcon(FontAwesome.PLUS);
		delete.addStyleName("light");

		delete.setEnabled(true);
		delete.setVisible(false);
		
		HorizontalLayout footer = new HorizontalLayout();
		footer.setMargin(new MarginInfo(false, false, true, false));
		footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		footer.addComponent(create);
		footer.addComponent(delete);
		left.addComponent(footer);

		// LIST USER

		Table table = getListTableUser("List User");
		HorizontalLayout footer3 = new HorizontalLayout();
		footer3.setMargin(new MarginInfo(false, false, false, false));
		footer3.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		footer3.setSizeFull();
		footer3.addComponent(table);
		left.addComponent(footer3);

	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	public Table getListTableUser(String text) {
		// VerticalLayout tableLayout = new VerticalLayout();
		// tableLayout.setSizeUndefined();
		final Table table = new Table(text);

		final List<UserData> productDatas = inventoryService.getAllUser();

		table.addStyleName("checkerboard");
		table.addContainerProperty("#", CheckBox.class, null);
		table.addContainerProperty("username", String.class, null);
//		table.addContainerProperty("action", HorizontalLayout.class, null);
		int index;
		Object object[];
		CheckBox check;
		table.setSelectable(true);
		table.setMultiSelect(true);
		for (final UserData userdata : productDatas) {

//			HorizontalLayout footers2 = SimpleTableActionUtil((DATA) userdata);
			object = new Object[2];
			check = new CheckBox("", false);
			check.addStyleName("small");
			check.setWidth("10px");
			object[0] = check;
			object[1] = userdata.getUsername();
//			object[2] = userdata.getId();
			// object[1] = footers2;
//			table.setSelectable(true);
			table.addItem(object, userdata);

		}
//		selectedColumn = "";
		
		table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
		    @Override
		    public void itemClick(final ItemClickEvent event) {
		        // TODO Auto-generated method stub
		    	selectedColumn = event.getItemId().toString();
//		    	Notification.show(selectedColumn);
		    	tesdata = (DATA)event.getItemId();
		        
		        form.setVisible(true);
				FormLayout forms = addEdit(form, left, tesdata);
				addComponent(forms);
				form.addStyleName("light");
				left.setVisible(false);
				
//		        if(event.isDoubleClick()){
//		        	Notification.show("THIS IS VIEW");
//		        	
//		        } else {
//		        	Notification.show("DELETE");
////		        	table.sets
////		        	table.select(event.getItemId());
//		        	delete.setVisible(true);
//		        }
//		        table.setCellStyleGenerator(new Table.CellStyleGenerator() {
//					
//					@Override
//					public String getStyle(Table source, Object itemId, Object propertyId) {
//						// TODO Auto-generated method stub
////						String color="";
//						Notification.show(selectedColumn);
//						Notification.show(itemId.toString());
//						if(itemId == event.getItemId())
//							return "black";
//						else
//						return "white";
//						
//						
//					}
//				});
//		        Notification.show(selectedColumn);
		    }
		});
//		table.setrows
//		table.setValue(table.getValue());
//		table.setSelectable(true);
		
//		table.setPageLength(15);
		// table.setHeight("300px");
		// table.setWidth("100%");
		table.setSizeFull();
		table.setColumnWidth(1, 5);
		return table;

	}

	@Override
	public FormLayout addEdit(FormLayout form, VerticalLayout left, DATA datas) {
		return productAddEdit.formCreateUser(form, left, datas);
	}

}
