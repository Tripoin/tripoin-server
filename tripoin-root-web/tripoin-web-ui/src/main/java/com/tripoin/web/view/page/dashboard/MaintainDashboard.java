package com.tripoin.web.view.page.dashboard;

import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;

import com.tripoin.core.dto.UserData;
import com.tripoin.web.service.IInventoryService;
import com.tripoin.web.servlet.VaadinView;
import com.tripoin.web.view.page.crud.ASimpleMaintainCrud;
import com.tripoin.util.ui.chart.HighChart;
import com.tripoin.web.view.page.product.ProductAddEdit;
import com.vaadin.annotations.JavaScript;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */

interface a {
//	String ip = "10.10.130.206";
	String ip = "192.168.43.64";
}

@Component
@Scope("prototype")
@VaadinView(value = "maintainDashboard", cached = true)
//@JavaScript({ "http://" + a.ip + "/sales-dashboard/js/jquery.min.js",
//		"http://" + a.ip + "/sales-dashboard/js/highcharts.js",
//		"http://" + a.ip + "/sales-dashboard/js/highcharts-3d.js",
//		"http://" + a.ip + "/sales-dashboard/js/grouped-categories.js",
//		"http://" + a.ip + "/sales-dashboard/js/properties.js",
//		"http://" + a.ip + "/sales-dashboard/js/modules/exporting.js",
//		"http://" + a.ip + "/sales-dashboard/js/highcharts-connector.js" })
// @JavaScript({"jquery-min.js", "highcharts.js", "highcharts-connector.js"})
public class MaintainDashboard<DATA> extends ASimpleMaintainCrud<DATA> implements View {

	private static final long serialVersionUID = -7326315426217377753L;
	

	@Autowired
	private IInventoryService inventoryService;
	
	// JAVA SCRIPT FOR SALES PERFORMANCE
//		public static final String INITIAL_HCJSA = new Scanner(MaintainDashboard.class.getResourceAsStream("chart-analisa-pemesanan.js"),
//				"UTF-8").useDelimiter("\\A").next();
//		public static final String INITIAL_HCJSB = new Scanner(
//				MaintainDashboard.class.getResourceAsStream("chart-analisa-produk.js"), "UTF-8").useDelimiter("\\A").next();
//		public static final String INITIAL_HCJSC = new Scanner(
//				MaintainDashboard.class.getResourceAsStream("chart-neraca-penjualan.js"), "UTF-8").useDelimiter("\\A").next();
//		public static final String INITIAL_HCJSD = new Scanner(
//				MaintainDashboard.class.getResourceAsStream("chart-bep.js"), "UTF-8").useDelimiter("\\A").next();



	// JAVA SCRIPT FOR CUSTOMER
	private BeanItemContainer<UserData> productContainer = new BeanItemContainer<>(UserData.class);
	public static final String INITIAL_HCJS1 = new Scanner(MaintainDashboard.class.getResourceAsStream("function1.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS2 = new Scanner(MaintainDashboard.class.getResourceAsStream("function2.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS3 = new Scanner(MaintainDashboard.class.getResourceAsStream("function3.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS4 = new Scanner(MaintainDashboard.class.getResourceAsStream("function4.js"),
			"UTF-8").useDelimiter("\\A").next();

	// JAVA SCRIPT FOR AREA
	public static final String INITIAL_HCJS5 = new Scanner(MaintainDashboard.class.getResourceAsStream("function5.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS6 = new Scanner(MaintainDashboard.class.getResourceAsStream("function6.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS7 = new Scanner(MaintainDashboard.class.getResourceAsStream("function7.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS8 = new Scanner(MaintainDashboard.class.getResourceAsStream("function8.js"),
			"UTF-8").useDelimiter("\\A").next();

	// JAVA SCRIPT FOR SALES PERFORMANCE
	public static final String INITIAL_HCJS9 = new Scanner(MaintainDashboard.class.getResourceAsStream("function9.js"),
			"UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS10 = new Scanner(
			MaintainDashboard.class.getResourceAsStream("function10.js"), "UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS11 = new Scanner(
			MaintainDashboard.class.getResourceAsStream("function11.js"), "UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS12 = new Scanner(
			MaintainDashboard.class.getResourceAsStream("function12.js"), "UTF-8").useDelimiter("\\A").next();

	public static final String INITIAL_HCJS13 = new Scanner(
			MaintainDashboard.class.getResourceAsStream("function13.js"), "UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS14 = new Scanner(
			MaintainDashboard.class.getResourceAsStream("function14.js"), "UTF-8").useDelimiter("\\A").next();
	public static final String INITIAL_HCJS15 = new Scanner(
			MaintainDashboard.class.getResourceAsStream("function15.js"), "UTF-8").useDelimiter("\\A").next();

	ProductAddEdit productAddEdit = new ProductAddEdit();

	@PostConstruct
	public void init() {
		// Page.getCurrent().getJavaScript().execute(""
		// + "var script= document.createElement('script');"
		// + "script.type= 'text/javascript';"
		// + "script.src=
		// 'http://192.168.43.64/sales-dashboard/js/jquery.min.js';"
		// + "script.async = true;"
		// + "document.body.appendChild(script);");
		setMargin(true);
        setSpacing(true);
       
		// setSizeFull();
		
		// form.addComponent(title);
//		addComponent(title);

		//form.addStyleName("dashboard");
		// left.setWidth("8");
		// addComponent(left);
//		form.setMargin(true);
//		form.setSizeFull();
		addComponent(form);
		// addComponent(wrap);
		// addComponent(wrap4);
		form.addComponent(awalDashboard());
		form.addComponent(salesChart());
		form.addComponent(areaChart());
		form.addComponent(salesPerformanceChart());
		form.addComponent(salesVisitQuote());

		// left.addComponent(footer3);

	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	@Override
	public FormLayout addEdit(FormLayout form, VerticalLayout left, DATA datas) {
		return productAddEdit.formCreateUser(form, left, datas);
	}
	
	public FormLayout awalDashboard() {
		HorizontalLayout wrap = new HorizontalLayout();
		wrap.addStyleName("wrapping");
		wrap.setSpacing(true);
//		wrap.setSizeFull();
		Label title = new Label("DASHBOARD");
		title.addStyleName("h1");
		title.setSizeFull();
		
		Label titles = new Label("");
		titles.addStyleName("h2");
		FormLayout layout = new FormLayout();
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSizeFull();
		footer.addComponent(titles);
		// addComponent(footer);
		layout.addComponent(title);
		layout.addComponent(footer);
		

		HighChart chart;

		// panel.setSizeFull();

		// Responsive.makeResponsive(csslay2);

		// CssLayout csslay = new CssLayout();

		// csslay.setMargin(new MarginInfo(true, true, true, true));
		List<UserData> productDatas = inventoryService.getAllUser();
		String categories="";
		String seriesdata="";
		int no =0;
		String coma = "";
		for (UserData userdata : productDatas) {
			no++;
			if(no == productDatas.size()){
				coma = "";
			} else {
				coma = ",";
			}
			categories = categories + "'"+userdata.getUsername()+"'"+coma;
			seriesdata = seriesdata + ""+userdata.getId()+""+coma;
		}
		
//		String categories="";
//		for (UserData userdata : productDatas) {
//			categories = categories + "'"+userdata.getUsername()+"',";
//		}
//		
		
		Notification.show(seriesdata);
//		Notification.show(categories);
		
//		BrowserFrame browser = new BrowserFrame("Contoh IFRAME",
//			    new ExternalResource("http://180.250.115.193:8181/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&_flowId=viewReportFlow&ParentFolderUri=%2FMQA%2FTelkomsel%2FReports&reportUnit=%2FMQA%2FTelkomsel%2FReports%2FActivtyAgent&j_username=jasperadmin&j_password=jasperadmin"));
//		wrap.addComponent(browser);

		chart = new HighChart();
		// chart.set
		chart.setHcjs(JsonUtilChart.CHART_ANALISA_PEMESANAN.toString());
//		chart.setWidth("40%");
//		Responsive.makeResponsive(chart);
//		wrap.setWidth("100%");
//		Notification.show(JsonUtilChart.CHART_ANALISA_PEMESANAN.toString());
		wrap.addComponent(chart);

		
		chart = new HighChart();
		chart.setHcjs(JsonUtilChart.CHART_ANALISA_PRODUK.toString());
		// chart.setWidth("40%");
//		Responsive.makeResponsive(wrap);
		// addComponent(createPanel("Dashboard Widget "));

		wrap.addComponent(chart);

		
		chart = new HighChart();
//		chart.setTitle("USER");
//		chart.setType("column");
//		chart.setCategories(categories);
//		chart.setSeriesname("User");
//		chart.setSeriesdata(seriesdata);
		String charttext = "{"
				+ "        chart: {"
				+ "            type: 'column'"
				+ "        },"
				+ "        title: {"
				+ "            text: 'User'"
				+ "        },"
				+ "        subtitle: {"
				+ "            text: ''"
				+ "        },"
				+ "        xAxis: {"
				+ "            categories: ["+categories+"],"
				+ "            crosshair: true"
				+ "        },"
				+ "        yAxis: {"
				+ "            min: 0,"
				+ "            title: {"
				+ "                text: 'jumlah produk' "
				+ "           }"
				+ "        },"
				+ "        tooltip: {"
				+ "            headerFormat: '<span style=\"font-size:10px\">{point.key}</span><table>',"
				+ "            pointFormat: '<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td><td style=\"padding:0\"><b>{point.y:.1f} </b></td></tr>',"
				+ "                "
				+ "            footerFormat: '</table>',"
				+ "            shared: true,"
				+ "            useHTML: true"
				+ "        },"
				+ "        plotOptions: {"
				+ "            column: {"
				+ "                pointPadding: 0.2,"
				+ "                borderWidth: 0"
				+ "            }"
				+ "        },"
				+ "        series: [{"
				+ "            name: 'User',"
				+ "            data: ["+seriesdata+"]"
				+ "        }]"
				+ "    }";
//		chart.setHcjs2("column","USER",categories,"User",seriesdata);
		chart.setHcjs(charttext);
		wrap.addComponent(chart);
		

		chart = new HighChart();
		chart.setHcjs(JsonUtilChart.CHART_NERACA_PENJUALAN);
		//chart.setHcjs2("column","USER",categories,"User",seriesdata);
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);

		wrap.addComponent(chart);

		
		chart = new HighChart();
		chart.setHcjs(JsonUtilChart.CHART_BEP);
		// chart.setWidth("40%");
//		Responsive.makeResponsive(chart);
		// panel.setContent(chart);
		wrap.addComponent(chart);
		wrap.addStyleName("wrapping");
		// addComponent(wrap);
		layout.addComponent(wrap);

		return layout;
	}

	public FormLayout salesChart() {
		HorizontalLayout wrap = new HorizontalLayout();
		wrap.addStyleName("wrapping");
		wrap.setSpacing(true);
		
		
		Label titles = new Label("SALES PIPE LINE");
		titles.addStyleName("h2");
		FormLayout layout = new FormLayout();
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSizeFull();
		footer.addComponent(titles);
		// addComponent(footer);
//		layout.addComponent(title);
		layout.addComponent(footer);
		

		HighChart chart;
		AceEditor textArea;

		// panel.setSizeFull();

		// Responsive.makeResponsive(csslay2);

		// CssLayout csslay = new CssLayout();

		// csslay.setMargin(new MarginInfo(true, true, true, true));
		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS1);
		textArea.setImmediate(true);

		chart = new HighChart();
		// chart.set
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		Responsive.makeResponsive(chart);

		wrap.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS2);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		Responsive.makeResponsive(wrap);
		// addComponent(createPanel("Dashboard Widget "));

		wrap.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();

		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS3);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);

		wrap.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS4);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		Responsive.makeResponsive(chart);
		// panel.setContent(chart);
		wrap.addComponent(chart);
		wrap.addStyleName("wrapping");
		// addComponent(wrap);
		layout.addComponent(wrap);

		return layout;
	}

	public FormLayout areaChart() {
		HorizontalLayout wrap2 = new HorizontalLayout();
		wrap2.addStyleName("wrapping");
		wrap2.setSpacing(true);
		Label titles = new Label("CUSTOMER AREA");
		titles.addStyleName("h2");
		FormLayout layout = new FormLayout();
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSizeFull();
		footer.addComponent(titles);
		// addComponent(footer);
		layout.addComponent(footer);

		HighChart chart;
		AceEditor textArea;

		// Responsive.makeResponsive(csslay2);

		// CssLayout csslay = new CssLayout();

		// csslay.setMargin(new MarginInfo(true, true, true, true));
		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS5);
		textArea.setImmediate(true);

		chart = new HighChart();
		// chart.set
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);

		wrap2.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS6);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);
		// addComponent(createPanel("Dashboard Widget "));

		wrap2.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();

		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS7);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);

		wrap2.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS8);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.set

		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);
		// panel.setContent(chart);
		wrap2.addComponent(chart);
		wrap2.addStyleName("wrapping");
		// addComponent(wrap2);
		layout.addComponent(wrap2);

		return layout;
	}

	public FormLayout salesPerformanceChart() {
		HorizontalLayout wrap3 = new HorizontalLayout();
		wrap3.addStyleName("wrapping");
		wrap3.setSpacing(true);
		Label titles = new Label("SALES PERFORMANCE");
		titles.addStyleName("h2");
		FormLayout layout = new FormLayout();
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSizeFull();
		footer.addComponent(titles);
		// addComponent(footer);
		layout.addComponent(footer);
		
		HighChart chart;
		AceEditor textArea;

		// Responsive.makeResponsive(csslay2);

		// CssLayout csslay = new CssLayout();

		// csslay.setMargin(new MarginInfo(true, true, true, true));
		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS9);
		textArea.setImmediate(true);

		chart = new HighChart();
		// chart.set
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);

		wrap3.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS10);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		Responsive.makeResponsive(chart);
		// addComponent(createPanel("Dashboard Widget "));

		wrap3.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();

		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS11);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.setWidth("40%");
		// Responsive.makeResponsive(chart);

		wrap3.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS12);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		// chart.set

		// chart.setWidth("40%");
		Responsive.makeResponsive(chart);
		// panel.setContent(chart);
		wrap3.addComponent(chart);
		// wrap3.addStyleName("wrapping");
		// addComponent(wrap3);
		layout.addComponent(wrap3);

		return layout;
	}

	public FormLayout salesVisitQuote() {
		HorizontalLayout wrap4 = new HorizontalLayout();
		wrap4.addStyleName("wrapping");
//		wrap4.setSpacing(true);
		Label titles = new Label("SALES VISIT VS QUOTATION");
		titles.addStyleName("h2");
		FormLayout layout = new FormLayout();
//		layout.addStyleName("wrapping");
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSizeFull();
		footer.addComponent(titles);
		layout.addComponent(footer);
		HighChart chart;
		AceEditor textArea;

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS13);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		wrap4.addComponent(chart);

		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS14);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());

		wrap4.addComponent(chart);
	
		textArea = new AceEditor();
		textArea.setSizeFull();
		textArea.setMode(AceMode.javascript);
		textArea.setValue(INITIAL_HCJS15);
		textArea.setImmediate(true);

		chart = new HighChart();
		chart.setHcjs(textArea.getValue());
		wrap4.addComponent(chart);
		layout.addComponent(wrap4);
//		layout.setSizeFull();
		return layout;
	}
}
