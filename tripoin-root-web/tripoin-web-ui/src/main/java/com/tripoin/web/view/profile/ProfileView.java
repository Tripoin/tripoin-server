package com.tripoin.web.view.profile;

import java.io.File;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.tripoin.core.common.ParameterConstant;
import com.tripoin.core.dto.ProfileData;
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
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
@Scope("prototype")
@VaadinView(value = "profile", cached = true)
public class ProfileView extends VerticalLayout implements View {

	private static final long serialVersionUID = -4592518571070450190L;

    @Autowired
    private IProfileService profileService;
    
    private ProfileData profileData;
    
	@SuppressWarnings("deprecation")
    @PostConstruct
    public void init(){
		profileData = profileService.getProfile();
//        setSpacing(true);
        setMargin(true);

        final FormLayout formTitle = new FormLayout();
        formTitle.setMargin(false);
        
        Label title = new Label("Edit Profile");
        title.addStyleName("h1");
        formTitle.addComponent(title);

        HorizontalLayout row = new HorizontalLayout();
        row.setSpacing(true);
        row.setMargin(false);
        row.setWidth("800px");
        row.addComponent(formTitle);
        addComponent(row);
        
        Image profilePhoto = new Image();
        profilePhoto.setSource(new File(profileData.getPhoto()).exists() ? new FileResource(new File(profileData.getPhoto())) : new ThemeResource("../tripoin-valo/img/profile-pic-new-300px.png")); 
        profilePhoto.setWidth("150px");
        profilePhoto.setHeight("150px");
        profilePhoto.addStyleName("light2");
        row.addComponent(profilePhoto);
        row.setComponentAlignment(profilePhoto, Alignment.TOP_RIGHT);

        final FormLayout form = new FormLayout();
        form.setMargin(false);
        form.setWidth("800px");
        form.addStyleName("light");
        addComponent(form);
        
        Label section = new Label("Personal Info");
        section.addStyleName("h3");
        section.addStyleName("colored");
        form.addComponent(section);
//        form.setComponentAlignment(section, Alignment.MIDDLE_LEFT);
        
        final TextField name = new TextField("Name");
        name.setValue(profileData.getName());
        name.setWidth("50%");
        form.addComponent(name);

        final DateField birthday = new DateField("Birth");
        birthday.setValue(new Date(80, 0, 31));
        form.addComponent(birthday);

        final TextField username = new TextField("Username");
        username.setValue(profileData.getUserData().getUsername());
        username.setWidth("50%");
        username.setRequired(true);
        form.addComponent(username);

        final OptionGroup sex = new OptionGroup("Gender");
        sex.addItem(ParameterConstant.FEMALE);
        sex.addItem(ParameterConstant.MALE);
        if(ParameterConstant.MALE.equalsIgnoreCase(profileData.getSex()))
        	sex.select(ParameterConstant.MALE);
        else
        	sex.select(ParameterConstant.FEMALE);
        sex.addStyleName("horizontal");
        form.addComponent(sex);

        section = new Label("Contact Info");
        section.addStyleName("h3");
        section.addStyleName("colored");
        form.addComponent(section);

        final TextField address = new TextField("Address");
        address.setValue(profileData.getAddress());
        address.setWidth("50%");
        form.addComponent(address);

        final TextField phone = new TextField("Phone");
        phone.setWidth("50%");
        phone.setValue(profileData.getPhone());
        form.addComponent(phone);

        final TextField primaryEmail = new TextField("Primary Email");
        primaryEmail.setValue(profileData.getUserData().getEmail());
        primaryEmail.setWidth("50%");
        primaryEmail.setRequired(true);
        form.addComponent(primaryEmail);

        final TextField additionalEmail = new TextField("Additional Email");
        additionalEmail.setValue(profileData.getEmail());
        additionalEmail.setWidth("50%");
        form.addComponent(additionalEmail);

        section = new Label("Additional Info");
        section.addStyleName("h4");
        section.addStyleName("colored");
        form.addComponent(section);

        final RichTextArea bio = new RichTextArea("Bio");
        bio.setValue(profileData.getBio());
        bio.setWidth("100%");
        form.addComponent(bio);

        form.setReadOnly(true);
        name.setReadOnly(true);
        birthday.setReadOnly(true);
        username.setReadOnly(true);
        sex.setReadOnly(true);
        address.setReadOnly(true);
        primaryEmail.setReadOnly(true);
        additionalEmail.setReadOnly(true);
        phone.setReadOnly(true);
        bio.setReadOnly(true);

        Button edit = new Button("Edit", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;
			@Override
            public void buttonClick(ClickEvent event) {
                boolean readOnly = form.isReadOnly();
                if (readOnly) {
                    form.setReadOnly(false);
                    name.setReadOnly(false);
                    birthday.setReadOnly(false);
                    username.setReadOnly(false);
                    sex.setReadOnly(false);
                    address.setReadOnly(false);
                    primaryEmail.setReadOnly(false);
                    additionalEmail.setReadOnly(false);
                    phone.setReadOnly(false);
                    bio.setReadOnly(false);
                    
                    form.removeStyleName("light");
                    event.getButton().setCaption("Save");
                    event.getButton().addStyleName("primary");
                } else {
                	profileData.setName(name.getValue());
                	profileData.setBirthdate(ParameterConstant.FORMAT_DEFAULT.format(birthday.getValue()));
                	profileData.getUserData().setUsername(username.getValue());
                	profileData.setSex(sex.getValue().toString());
                	profileData.setAddress(address.getValue());
                	profileData.setPhone(phone.getValue());
                	profileData.getUserData().setEmail(primaryEmail.getValue());
                	profileData.setEmail(additionalEmail.getValue());
                	profileData.setBio(bio.getValue());
                	profileService.updateProfile(profileData, profileData.getUserData());
                    form.setReadOnly(true);
                    name.setReadOnly(true);
                    birthday.setReadOnly(true);
                    username.setReadOnly(true);
                    sex.setReadOnly(true);
                    address.setReadOnly(true);
                    primaryEmail.setReadOnly(true);
                    additionalEmail.setReadOnly(true);
                    phone.setReadOnly(true);
                    bio.setReadOnly(true);
                    
                    form.addStyleName("light");
                    event.getButton().setCaption("Edit");
                    event.getButton().removeStyleName("primary");
                }
            }
        });

        HorizontalLayout footer = new HorizontalLayout();
        footer.setMargin(new MarginInfo(true, false, true, false));
        footer.setSpacing(true);
        footer.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        form.addComponent(footer);
        footer.addComponent(edit);

        Label lastModified = new Label("Last modified by you a minute ago");
        lastModified.addStyleName("light");
        footer.addComponent(lastModified);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }
    
}
