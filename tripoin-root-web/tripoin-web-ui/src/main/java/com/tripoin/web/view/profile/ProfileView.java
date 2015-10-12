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
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
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
        row.addStyleName("light");
        row.addComponent(formTitle);
        addComponent(row);
        
        Image profilePhoto = new Image();
        profilePhoto.setSource(new FileResource(new File(profileData.getPhoto())));
        profilePhoto.setWidth("150px");
        profilePhoto.setHeight("150px");
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
        form.addComponent(username);
        
        final TextField password = new TextField("Password");
        password.setValue(profileData.getUserData().getPassword());
        password.setWidth("50%");
        form.addComponent(password);

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

        final TextField email = new TextField("Email");
        email.setValue(profileData.getEmail());
        email.setWidth("50%");
        email.setRequired(true);
        form.addComponent(email);

        HorizontalLayout wrap = new HorizontalLayout();
        wrap.setSpacing(true);
        wrap.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        wrap.setCaption("Newsletter");
        final CheckBox newsletter = new CheckBox("Subscribe to newsletter", true);
        wrap.addComponent(newsletter);

        final ComboBox period = new ComboBox();
        period.setTextInputAllowed(false);
        period.addItem("Daily");
        period.addItem("Weekly");
        period.addItem("Monthly");
        period.setNullSelectionAllowed(false);
        period.select("Weekly");
        period.addStyleName("small");
        period.setWidth("10em");
        wrap.addComponent(period);
        form.addComponent(wrap);

        section = new Label("Additional Info");
        section.addStyleName("h4");
        section.addStyleName("colored");
        form.addComponent(section);

        final RichTextArea bio = new RichTextArea("Bio");
        bio.setWidth("100%");
        bio.setValue("<div><p><span>Integer legentibus erat a ante historiarum dapibus.</span> <span>Vivamus sagittis lacus vel augue laoreet rutrum faucibus.</span> <span>A communi observantia non est recedendum.</span> <span>Morbi fringilla convallis sapien, id pulvinar odio volutpat.</span> <span>Ab illo tempore, ab est sed immemorabili.</span> <span>Quam temere in vitiis, legem sancimus haerentia.</span></p><p><span>Morbi odio eros, volutpat ut pharetra vitae, lobortis sed nibh.</span> <span>Quam diu etiam furor iste tuus nos eludet?</span> <span>Cum sociis natoque penatibus et magnis dis parturient.</span> <span>Quam diu etiam furor iste tuus nos eludet?</span> <span>Tityre, tu patulae recubans sub tegmine fagi  dolor.</span></p><p><span>Curabitur blandit tempus ardua ridiculus sed magna.</span> <span>Phasellus laoreet lorem vel dolor tempus vehicula.</span> <span>Etiam habebis sem dicantur magna mollis euismod.</span> <span>Hi omnes lingua, institutis, legibus inter se differunt.</span></p></div>");
        form.addComponent(bio);

        form.setReadOnly(true);
        name.setReadOnly(true);
        birthday.setReadOnly(true);
        username.setReadOnly(true);
        password.setReadOnly(true);
        sex.setReadOnly(true);
        address.setReadOnly(true);
        email.setReadOnly(true);
        newsletter.setReadOnly(true);
        phone.setReadOnly(true);
        period.setReadOnly(true);
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
                    password.setReadOnly(false);
                    sex.setReadOnly(false);
                    address.setReadOnly(false);
                    email.setReadOnly(false);
                    newsletter.setReadOnly(false);
                    phone.setReadOnly(false);
                    period.setReadOnly(false);
                    bio.setReadOnly(false);
                    
                    form.removeStyleName("light");
                    event.getButton().setCaption("Save");
                    event.getButton().addStyleName("primary");
                } else {
                    form.setReadOnly(true);
                    name.setReadOnly(true);
                    birthday.setReadOnly(true);
                    username.setReadOnly(true);
                    password.setReadOnly(true);
                    sex.setReadOnly(true);
                    address.setReadOnly(true);
                    email.setReadOnly(true);
                    newsletter.setReadOnly(true);
                    phone.setReadOnly(true);
                    period.setReadOnly(true);
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
