package com.tripoin.util.report;

import java.io.File;
import java.io.OutputStream;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
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
        JasperDesign jasperDesign=loadTemplate(reportFilename);
        setTempDirectory(reportFilename);
        JasperReport jasperReport=compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,  params, dataSource);		

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();
	}
	
	/**
     * Load the template (defined by templatePath) and return a JasperDesign object representing the template
     * @return JasperDesign
     */
    private JasperDesign loadTemplate(String templatePath){
        JasperDesign jasperDesign=null;
        File templateFile=new File(templatePath);
        if(templateFile.exists()){
            try {
                jasperDesign= JRXmlLoader.load(templateFile);
            } catch (JRException e) {
            	e.printStackTrace();
            }
        }
        else
            System.out.println("Error, the file dont exists");
        return(jasperDesign);
    }

    /**
     * Compile the report and generates a binary version of it
     * @param jasperDesign The report design
     * @return JasperReport
     */
    private JasperReport compileReport(JasperDesign jasperDesign){
        JasperReport jasperReport=null;
        try {
            jasperReport= JasperCompileManager.compileReport(jasperDesign);
        } catch (JRException e) {
            e.printStackTrace();
        }
        return(jasperReport);
    }
    
    /**
     * Set the temp directory for report generation
     */
    private void setTempDirectory(String templatePath){
        File templateFile=new File(templatePath);
        if(templateFile.exists()){
            System.setProperty("jasper.reports.compile.temp", templateFile.getParent());
        }
    }

}
