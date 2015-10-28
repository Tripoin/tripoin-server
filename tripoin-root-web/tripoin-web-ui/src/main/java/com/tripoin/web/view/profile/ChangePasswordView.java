package com.tripoin.web.view.profile;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripoin.core.dto.ProfileData;
import com.tripoin.web.service.IPasswordService;
import com.tripoin.web.service.IProfileService;
import com.tripoin.web.service.impl.PasswordServiceImpl;
import com.tripoin.web.servlet.VaadinView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
@Scope("prototype")
@VaadinView(value = "changePassword", cached = true)
public class ChangePasswordView extends VerticalLayout implements View {

	private static final long serialVersionUID = -4592518571070450190L;

    @Autowired
    private IPasswordService passwordService;
    @Autowired
    private IProfileService profileService;
    private ProfileData profileData;
    
    @PostConstruct
    public void init(){
		profileData = profileService.getProfile();
        setSpacing(false);
        setMargin(true);

        final FormLayout form = new FormLayout();
        form.setSizeFull();
        addComponent(form);
        
        Label title = new Label("Change Password");
        title.addStyleName("h1");
        form.addComponent(title);

        
        HorizontalLayout rowOp = new HorizontalLayout();
        rowOp.setWidth("30%");
        
        Label labelOp = new Label("Old Password");
        rowOp.addComponent(labelOp);
        
        final PasswordField oldPassword = new PasswordField();
        oldPassword.addStyleName("inline-icon");
        oldPassword.setIcon(FontAwesome.LOCK);
        oldPassword.setInputPrompt("anjarganteng");
        rowOp.addComponent(oldPassword);
        form.addComponent(rowOp);
        
        HorizontalLayout rowNp = new HorizontalLayout();
        rowNp.setWidth("30%");
        
        Label labelNp = new Label("New Password");
        rowNp.addComponent(labelNp);
        
        final PasswordField newPassword = new PasswordField();
        newPassword.addStyleName("inline-icon");
        newPassword.setIcon(FontAwesome.LOCK);
        newPassword.setInputPrompt("anjarganteng");
        rowNp.addComponent(newPassword);
        form.addComponent(rowNp);

        
        HorizontalLayout rowRp = new HorizontalLayout();
        rowRp.setWidth("30%");
        
        Label labelRp = new Label("Re-type Password");
        rowRp.addComponent(labelRp);
        
        final PasswordField reTypePassword = new PasswordField();
        reTypePassword.addStyleName("inline-icon");
        reTypePassword.setIcon(FontAwesome.LOCK);
        reTypePassword.setInputPrompt("anjarganteng");
        rowRp.addComponent(reTypePassword);
        form.addComponent(rowRp);

        Button save = new Button("Save", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;
			@Override
            public void buttonClick(ClickEvent event) {
				if(newPassword.getValue()!=null && reTypePassword.getValue()!=null && newPassword.getValue().equals(reTypePassword.getValue())){
					profileData.getUserData().setPassword(newPassword.getValue());
					passwordService.updatePassword(profileData.getUserData());
				}
			}
        });

        HorizontalLayout footer = new HorizontalLayout();
        footer.setMargin(new MarginInfo(true, false, true, false));
        footer.setSpacing(true);
        footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        footer.setSizeFull();
        form.addComponent(footer);
        footer.addComponent(save);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }
    
}
