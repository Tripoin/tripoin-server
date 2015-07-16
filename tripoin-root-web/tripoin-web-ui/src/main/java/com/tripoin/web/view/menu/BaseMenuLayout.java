package com.tripoin.web.view.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import com.tripoin.web.authentication.IAccessControl;
import com.tripoin.web.servlet.DiscoveryNavigator;
import com.tripoin.web.view.valo.TestIcon;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class BaseMenuLayout extends CssLayout implements View {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4795419684894048255L;
	private final Map<String, String> menuItems = new HashMap<String, String>();
    private static Map<String, String> themeVariants = new HashMap<String, String>();
    private final TestIcon baseIcon = new TestIcon(100);
    CssLayout menuItemsLayout = new CssLayout();
    {
        setId("BaseMenu");
    }
    static {
        themeVariants.put("tripoin-valo", "Default");
        themeVariants.put("tripoin-valo-blueprint", "Blueprint");
        themeVariants.put("tripoin-valo-dark", "Dark");
        themeVariants.put("tripoin-valo-facebook", "Facebook");
        themeVariants.put("tripoin-valo-flatdark", "Flat dark");
        themeVariants.put("tripoin-valo-flat", "Flat");
        themeVariants.put("tripoin-valo-light", "Light");
        themeVariants.put("tripoin-valo-metro", "Metro");
    }	
    private DiscoveryNavigator navigator;
	
    private IAccessControl accessControl;

	public Map<String, String> getMenuItems() {
		return menuItems;
	}

	public CssLayout getMenuItemsLayout() {
		return menuItemsLayout;
	}

	public void setNavigator(DiscoveryNavigator navigator) {
		this.navigator = navigator;
	}

	public void setAccessControl(IAccessControl accessControl) {
		this.accessControl = accessControl;
	}
	
	public BaseMenuLayout getMenu() {
        final HorizontalLayout top = new HorizontalLayout();
        top.setWidth("100%");
        top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        top.addStyleName("valo-menu-title");
        addComponent(top);
        addComponent(createThemeSelect());

        final Button showMenu = new Button("Menu", new ClickListener() {
        	
			private static final long serialVersionUID = -4671912497297145261L;

			@Override
            public void buttonClick(final ClickEvent event) {
                if (getStyleName().contains("valo-menu-visible")) {
                    removeStyleName("valo-menu-visible");
                } else {
                    addStyleName("valo-menu-visible");
                }
            }
        });
        showMenu.addStyleName(ValoTheme.BUTTON_PRIMARY);
        showMenu.addStyleName(ValoTheme.BUTTON_SMALL);
        showMenu.addStyleName("valo-menu-toggle");
        showMenu.setIcon(FontAwesome.LIST);
        addComponent(showMenu);

        final Label title = new Label("<h3>Web Application <strong>Tripoin</strong></h3>", ContentMode.HTML);
        title.setSizeUndefined();
        top.addComponent(title);
        top.setExpandRatio(title, 1);

        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        final MenuItem settingsItem = settings.addItem(accessControl.getUsername(),
                new ThemeResource("../tripoin-valo/img/profile-pic-300px.jpg"),
                null);
        settingsItem.addItem("Edit Profile", null);
        settingsItem.addItem("Preferences", null);
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", FontAwesome.SIGN_OUT, new Command() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -7829505006330125630L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
                VaadinSession.getCurrent().getSession().invalidate();
                getSession().close();
                getUI().close();
                Page.getCurrent().reload();
			}
		});
        addComponent(settings);

        menuItemsLayout.setPrimaryStyleName("valo-menuitems");
        addComponent(menuItemsLayout);

        Label label = null;
        int count = -1;
        for (final Entry<String, String> item : menuItems.entrySet()) {
            if (item.getKey().equals("labels")) {
                label = new Label("Components", ContentMode.HTML);
                label.setPrimaryStyleName("valo-menu-subtitle");
                label.addStyleName("h4");
                label.setSizeUndefined();
                menuItemsLayout.addComponent(label);
            }
            if (item.getKey().equals("panels")) {
                label.setValue(label.getValue()
                        + " <span class=\"valo-menu-badge\">" + count
                        + "</span>");
                count = 0;
                label = new Label("Containers", ContentMode.HTML);
                label.setPrimaryStyleName("valo-menu-subtitle");
                label.addStyleName("h4");
                label.setSizeUndefined();
                menuItemsLayout.addComponent(label);
            }
            if (item.getKey().equals("forms")) {
                label.setValue(label.getValue()
                        + " <span class=\"valo-menu-badge\">" + count
                        + "</span>");
                count = 0;
                label = new Label("Other", ContentMode.HTML);
                label.setPrimaryStyleName("valo-menu-subtitle");
                label.addStyleName("h4");
                label.setSizeUndefined();
                menuItemsLayout.addComponent(label);
            }
            final Button b = new Button(item.getValue(), new ClickListener() {
            	
                /**
				 * 
				 */
				private static final long serialVersionUID = -8962701523482133238L;

				@Override
                public void buttonClick(final ClickEvent event) {
                    navigator.navigateTo(item.getKey());
                }
            });
            if (count == 2) {
                b.setCaption(b.getCaption()
                        + " <span class=\"valo-menu-badge\">123</span>");
            }
            b.setHtmlContentAllowed(true);
            b.setPrimaryStyleName("valo-menu-item");
            b.setIcon(baseIcon.get());
            menuItemsLayout.addComponent(b);
            count++;
        }
        label.setValue(label.getValue() + " <span class=\"valo-menu-badge\">" + count + "</span>");
        return this;
	}
	
	@PostConstruct
	public void init(){
        menuItems.put("common", "Common UI Elements");
        menuItems.put("labels", "Labels");
        menuItems.put("buttons-and-links", "Buttons & Links");
        menuItems.put("textfields", "Text Fields");
        menuItems.put("datefields", "Date Fields");
        menuItems.put("comboboxes", "Combo Boxes");
        menuItems.put("selects", "Selects");
        menuItems.put("checkboxes", "Check Boxes & Option Groups");
        menuItems.put("sliders", "Sliders & Progress Bars");
        menuItems.put("colorpickers", "Color Pickers");
        menuItems.put("menubars", "Menu Bars");
        menuItems.put("trees", "Trees");
        menuItems.put("tables", "Tables");
        menuItems.put("dragging", "Drag and Drop");
        menuItems.put("panels", "Panels");
        menuItems.put("splitpanels", "Split Panels");
        menuItems.put("tabs", "Tabs");
        menuItems.put("accordions", "Accordions");
        menuItems.put("popupviews", "Popup Views");
        // menuItems.put("calendar", "Calendar");
        menuItems.put("forms", "Forms");
	}

    @SuppressWarnings("unchecked")
	private Component createThemeSelect() {
        final NativeSelect ns = new NativeSelect();
        ns.setNullSelectionAllowed(false);
        ns.setId("themeSelect");
        ns.addContainerProperty("caption", String.class, "");
        ns.setItemCaptionPropertyId("caption");
        for (final String identifier : themeVariants.keySet()) {
            ns.addItem(identifier).getItemProperty("caption").setValue(themeVariants.get(identifier));
        }

        ns.setValue("tripoin-valo");
        ns.addValueChangeListener(new ValueChangeListener() {
        	
            /**
			 * 
			 */
			private static final long serialVersionUID = 4509042852150358788L;

			@Override
            public void valueChange(final ValueChangeEvent event) {
                getUI().setTheme((String) ns.getValue());
            }
        });
        return ns;
    }

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
