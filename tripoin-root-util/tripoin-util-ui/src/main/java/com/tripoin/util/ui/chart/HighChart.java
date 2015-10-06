package com.tripoin.util.ui.chart;

import com.vaadin.annotations.JavaScript;

/**
 * This is the chart class we are using in the demo application.
 * It loads jquery 1.7.1 and highcharts.js located in the same package.
 * Extend you own class in order to load other JS files.
 * Make sure "highcharts-connector.js" is loaded at the end.
 *
 * @author <a href="mailto:tripoinstudio@gmail.com">Tripoin, inc.</a>
 */
@JavaScript({"jquery.min.js", "highcharts.js", "highcharts-connector.js"})
public class HighChart extends AbstractHighChart {
	private static final long serialVersionUID = -7326315426217377753L;
}
