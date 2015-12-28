package com.tripoin.util.report;

import java.io.OutputStream;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportGenerator {
	
	public static final ReportGenerator instance;
	
	private ReportGenerator() {}
	
	static {
		instance = new ReportGenerator();
	}
	
	public static ReportGenerator getInstance() {
		return instance;
	}
	
	public void printReportToFile(String reportFilename, JRDataSource dataSource, Map<String, Object> params, String outputFilename, OutputStream outputStream) throws Exception {
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportFilename,  params, dataSource);
        
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();
	}	

}
