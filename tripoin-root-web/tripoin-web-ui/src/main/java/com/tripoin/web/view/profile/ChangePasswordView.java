package com.tripoin.web.view.profile;

import java.io.File;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tripoin.core.dto.ProfileData;
import com.tripoin.web.TripoinUI;
import com.tripoin.web.service.IProfileService;
import com.tripoin.web.servlet.VaadinView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
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
    private IProfileService profileService;
    
    private ProfileData profileData;
    
    @PostConstruct
    public void init(){
		profileData = profileService.getProfile();
//        setSpacing(true);
        setMargin(true);

        final FormLayout formTitle = new FormLayout();
        formTitle.setMargin(false);
        formTitle.addStyleName("light");
        
        Label title = new Label("Change Password");
        title.addStyleName("h1");
        formTitle.addComponent(title);

        HorizontalLayout row = new HorizontalLayout();
        row.setSpacing(true);
        row.setMargin(false);
        row.setWidth("800px");
        row.addComponent(formTitle);
        addComponent(row);
        
//        Image profilePhoto = new Image();
//        profilePhoto.setSource(new File(profileData.getPhoto()).exists() ? new FileResource(new File(profileData.getPhoto())) : new ThemeResource("../tripoin-valo/img/profile-pic-new-300px.png")); 
//        profilePhoto.setWidth("150px");
//        profilePhoto.setHeight("150px");
//        profilePhoto.addStyleName("light2");
//        row.addComponent(profilePhoto);
//        row.setComponentAlignment(profilePhoto, Alignment.TOP_RIGHT);

        final FormLayout form = new FormLayout();
        form.setMargin(false);
        form.setWidth("800px");
        addComponent(form);
        
        Label section = new Label(" ");
        section.addStyleName("h3");
        section.addStyleName("colored");
        form.addComponent(section);
//        form.setComponentAlignment(section, Alignment.MIDDLE_LEFT);
        
        final TextField oldPassword = new TextField("Old Password");
        oldPassword.setRequired(true);
        oldPassword.setWidth("50%");
        form.addComponent(oldPassword);
        
        final TextField newPassword = new TextField("New Password");
        newPassword.setRequired(true);
        newPassword.setWidth("50%");
        form.addComponent(newPassword);
        
        final TextField reTypePassword = new TextField("Re-type Password");
        reTypePassword.setRequired(true);
        reTypePassword.setWidth("50%");
        form.addComponent(reTypePassword);

        Button save = new Button("Save", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;
			@Override
            public void buttonClick(ClickEvent event) {
                TripoinUI.get().close();
			}
        });

        HorizontalLayout footer = new HorizontalLayout();
        footer.setMargin(new MarginInfo(true, false, true, false));
        footer.setSpacing(true);
        footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        form.addComponent(footer);
        footer.addComponent(save);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }
    
}
