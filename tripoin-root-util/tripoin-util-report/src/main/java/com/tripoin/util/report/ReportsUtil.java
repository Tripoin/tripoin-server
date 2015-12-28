package com.tripoin.util.report;

import com.tripoin.util.report.common.EReportUtilConstant;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReportsUtil {

    private String baseReportsPath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath().concat("/WEB-INF/classes/report/");
	public static final ReportsUtil instance;
	
	private ReportsUtil() {}
	
	static {
		instance = new ReportsUtil();
	}
	
	public static ReportsUtil getInstance() {
		return instance;
	}
	
    public StreamResource createPdfReport(Collection<?> data, String reportFilename, Map<String, Object> params, String outputFilename){
    	JRDataSource dataSource = getDataSource(data);
    	if(params == null)
    		params = new HashMap<String, Object>();
		params.put("datasource", dataSource);
    	outputFilename = outputFilename.concat(UUID.randomUUID().toString()).concat(EReportUtilConstant.REPORT_PDF.getString());
        return createStreamResource(dataSource, reportFilename, params, outputFilename);        
    }
    
	/**
	 * Returns a data source that's wrapped within {@link JRDataSource}
	 * @param data
	 * @return
	 */
	public JRDataSource getDataSource(Collection<?> data) {
		return new JRBeanCollectionDataSource(data);
	}
    
	/**
	 * @param dataSource
	 * @param reportFilename
	 * @param params
	 * @param outputFilename
	 * @return
	 */
    private StreamResource createStreamResource(final JRDataSource dataSource, final String reportFilename, final Map<String, Object> params, final String outputFilename){
    	return new StreamResource(new StreamResource.StreamSource() {
			private static final long serialVersionUID = -7890689648689132725L;
			@Override
            public InputStream getStream () {
                ByteArrayOutputStream pdfBuffer = new ByteArrayOutputStream();
                ReportGenerator reportGenerator = ReportGenerator.getInstance();
                try {
					reportGenerator.printReportToFile(baseReportsPath.concat(reportFilename), dataSource, params, outputFilename, pdfBuffer);
				} catch (Exception e) {
					e.printStackTrace();
				}
                return new ByteArrayInputStream(pdfBuffer.toByteArray());
            }
        }, outputFilename);
    }

}
