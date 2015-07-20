package com.tripoin.web.view.valo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripoin.web.servlet.VaadinView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component
@Scope("prototype")
@VaadinView(value = "sliders", cached = true)
public class Sliders extends VerticalLayout implements View {
	
	private static final long serialVersionUID = -7651613671275252824L;

	public Sliders() {
        setMargin(true);

        Label h1 = new Label("Sliders");
        h1.addStyleName("h1");
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName("wrapping");
        row.setSpacing(true);
        addComponent(row);

        Slider slider = new Slider("Horizontal");
        slider.setValue(50.0);
        row.addComponent(slider);

        slider = new Slider("Horizontal, sized");
        slider.setValue(50.0);
        slider.setWidth("200px");
        row.addComponent(slider);

        slider = new Slider("Custom handle");
        slider.setValue(50.0);
        slider.setWidth("200px");
        slider.addStyleName("color1");
        row.addComponent(slider);

        slider = new Slider("Custom track");
        slider.setValue(50.0);
        slider.setWidth("200px");
        slider.addStyleName("color2");
        row.addComponent(slider);

        slider = new Slider("Custom indicator");
        slider.setValue(50.0);
        slider.setWidth("200px");
        slider.addStyleName("color3");
        row.addComponent(slider);

        slider = new Slider("No indicator");
        slider.setValue(50.0);
        slider.setWidth("200px");
        slider.addStyleName("no-indicator");
        row.addComponent(slider);

        slider = new Slider("With ticks (not in IE8 & IE9)");
        slider.setValue(3.0);
        slider.setWidth("200px");
        slider.setMax(4);
        slider.addStyleName("ticks");
        row.addComponent(slider);

        slider = new Slider("Toggle imitation");
        slider.setWidth("50px");
        slider.setResolution(0);
        slider.setMin(0);
        slider.setMax(1);
        row.addComponent(slider);

        slider = new Slider("Vertical");
        slider.setValue(50.0);
        slider.setOrientation(SliderOrientation.VERTICAL);
        row.addComponent(slider);

        slider = new Slider("Vertical, sized");
        slider.setValue(50.0);
        slider.setOrientation(SliderOrientation.VERTICAL);
        slider.setHeight("200px");
        row.addComponent(slider);

        slider = new Slider("Custom handle");
        slider.setValue(50.0);
        slider.setHeight("200px");
        slider.addStyleName("color1");
        slider.setOrientation(SliderOrientation.VERTICAL);
        row.addComponent(slider);

        slider = new Slider("Custom track");
        slider.setValue(50.0);
        slider.setHeight("200px");
        slider.addStyleName("color2");
        slider.setOrientation(SliderOrientation.VERTICAL);
        row.addComponent(slider);

        slider = new Slider("Custom indicator");
        slider.setValue(50.0);
        slider.setHeight("200px");
        slider.addStyleName("color3");
        slider.setOrientation(SliderOrientation.VERTICAL);
        row.addComponent(slider);

        slider = new Slider("No indicator");
        slider.setValue(50.0);
        slider.setHeight("200px");
        slider.addStyleName("no-indicator");
        slider.setOrientation(SliderOrientation.VERTICAL);
        row.addComponent(slider);

        slider = new Slider("With ticks");
        slider.setValue(3.0);
        slider.setHeight("200px");
        slider.setMax(4);
        slider.addStyleName("ticks");
        slider.setOrientation(SliderOrientation.VERTICAL);
        row.addComponent(slider);

        slider = new Slider("Disabled");
        slider.setValue(50.0);
        slider.setEnabled(false);
        row.addComponent(slider);

        h1 = new Label("Progress Bars");
        h1.addStyleName("h1");
        addComponent(h1);

        row = new HorizontalLayout();
        row.addStyleName("wrapping");
        row.setSpacing(true);
        addComponent(row);

        pb = new ProgressBar();
        pb.setCaption("Default");
        pb.setWidth("300px");
        // pb.setValue(0.6f);
        row.addComponent(pb);

        pb2 = new ProgressBar();
        pb2.setCaption("Point style");
        pb2.setWidth("300px");
        pb2.addStyleName("point");
        // pb2.setValue(0.6f);
        row.addComponent(pb2);

        ProgressBar pb3 = new ProgressBar();
        pb3.setIndeterminate(true);
        pb3.setCaption("Indeterminate");
        row.addComponent(pb3);
    }

    float progress = 0;

    Thread update = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    getUI().access(new Runnable() {
                        @Override
                        public void run() {
                            pb.setValue(progress);
                            pb2.setValue(progress);
                            if (progress > 1) {
                                progress = 0;
                            } else {
                                progress += 0.2 * Math.random();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    break;
                }
            }
        };
    };
    private ProgressBar pb;
    private ProgressBar pb2;

    @Override
    public void enter(ViewChangeEvent event) {    
        getUI().setPollInterval(1000);
        update.start();
    }

    @Override
    public void detach() {
        getUI().setPollInterval(-1);
        update.interrupt();
        super.detach();
    }

}
