package com.tripoin.util.report;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportGenerator {
	
	@Autowired
	private JasperReportCompiler jasperReportCompiler;
	
	public void printReportToFile(String reportFilename, JRDataSource dataSource, Map<String, Object> params, OutputStream outputStream) throws Exception {
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReportCompiler.getBaseFileReportsPath().getPath().concat(File.separator).concat(reportFilename), params, dataSource);
		pdfExporter(jasperPrint, outputStream);
	}
	
	public void printReportToFile(String reportFilename, Connection connection, Map<String, Object> params, OutputStream outputStream) throws Exception {
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReportCompiler.getBaseFileReportsPath().getPath().concat(File.separator).concat(reportFilename), params, connection);
		pdfExporter(jasperPrint, outputStream);        
	}
	
	private void pdfExporter(JasperPrint jasperPrint, OutputStream outputStream) throws JRException{
		JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();
	}

}
