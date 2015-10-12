package com.tripoin.web.view.profile;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripoin.core.common.ParameterConstant;
import com.tripoin.core.dto.ProfileData;
import com.tripoin.web.service.IProfileService;
import com.tripoin.web.servlet.VaadinView;
import com.tripoin.web.view.page.StringGenerator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.UserError;
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
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
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
        setSpacing(true);
        setMargin(true);

        Label title = new Label("Edit Profile");
        title.addStyleName("h1");
        addComponent(title);

        final FormLayout form = new FormLayout();
        form.setMargin(false);
        form.setWidth("800px");
        form.addStyleName("light");
        addComponent(form);

        Label section = new Label("Personal Info");
        section.addStyleName("h2");
        section.addStyleName("colored");
        form.addComponent(section);
        StringGenerator sg = new StringGenerator();

        TextField name = new TextField("Name");
        name.setValue(profileData.getName());
        name.setWidth("50%");
        form.addComponent(name);

        DateField birthday = new DateField("Place of Birth");
        birthday.setValue(new Date(80, 0, 31));
        form.addComponent(birthday);

        TextField username = new TextField("Username");
        username.setValue(sg.nextString(false) + sg.nextString(false));
        username.setRequired(true);
        form.addComponent(username);

        OptionGroup sex = new OptionGroup("Sex");
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

        TextField email = new TextField("Email");
        email.setValue(profileData.getEmail());
        email.setWidth("50%");
        email.setRequired(true);
        form.addComponent(email);

        TextField location = new TextField("Location");
        location.setValue(sg.nextString(true) + ", " + sg.nextString(true));
        location.setWidth("50%");
        location.setComponentError(new UserError("This address doesn't exist"));
        form.addComponent(location);

        TextField phone = new TextField("Phone");
        phone.setWidth("50%");
        phone.setValue(profileData.getPhone());
        form.addComponent(phone);

        HorizontalLayout wrap = new HorizontalLayout();
        wrap.setSpacing(true);
        wrap.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        wrap.setCaption("Newsletter");
        CheckBox newsletter = new CheckBox("Subscribe to newsletter", true);
        wrap.addComponent(newsletter);

        ComboBox period = new ComboBox();
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

        TextField website = new TextField("Website");
        website.setInputPrompt("http://");
        website.setWidth("100%");
        form.addComponent(website);

        TextArea shortbio = new TextArea("Short Bio");
        shortbio.setValue("Quis aute iure reprehenderit in voluptate velit esse. Cras mattis iudicium purus sit amet fermentum.");
        shortbio.setWidth("100%");
        shortbio.setRows(2);
        form.addComponent(shortbio);

        final RichTextArea bio = new RichTextArea("Bio");
        bio.setWidth("100%");
        bio.setValue("<div><p><span>Integer legentibus erat a ante historiarum dapibus.</span> <span>Vivamus sagittis lacus vel augue laoreet rutrum faucibus.</span> <span>A communi observantia non est recedendum.</span> <span>Morbi fringilla convallis sapien, id pulvinar odio volutpat.</span> <span>Ab illo tempore, ab est sed immemorabili.</span> <span>Quam temere in vitiis, legem sancimus haerentia.</span></p><p><span>Morbi odio eros, volutpat ut pharetra vitae, lobortis sed nibh.</span> <span>Quam diu etiam furor iste tuus nos eludet?</span> <span>Cum sociis natoque penatibus et magnis dis parturient.</span> <span>Quam diu etiam furor iste tuus nos eludet?</span> <span>Tityre, tu patulae recubans sub tegmine fagi  dolor.</span></p><p><span>Curabitur blandit tempus ardua ridiculus sed magna.</span> <span>Phasellus laoreet lorem vel dolor tempus vehicula.</span> <span>Etiam habebis sem dicantur magna mollis euismod.</span> <span>Hi omnes lingua, institutis, legibus inter se differunt.</span></p></div>");
        form.addComponent(bio);

        form.setReadOnly(true);
        bio.setReadOnly(true);

        Button edit = new Button("Edit", new ClickListener() {
			private static final long serialVersionUID = 2260935572262992380L;
			@Override
            public void buttonClick(ClickEvent event) {
                boolean readOnly = form.isReadOnly();
                if (readOnly) {
                    bio.setReadOnly(false);
                    form.setReadOnly(false);
                    form.removeStyleName("light");
                    event.getButton().setCaption("Save");
                    event.getButton().addStyleName("primary");
                } else {
                    bio.setReadOnly(true);
                    form.setReadOnly(true);
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