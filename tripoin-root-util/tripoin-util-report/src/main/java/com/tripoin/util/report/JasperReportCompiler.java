package com.tripoin.util.report;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;

import com.vaadin.server.VaadinService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class JasperReportCompiler implements InitializingBean {

    private static Logger LOGGER = LoggerFactory.getLogger(JasperReportCompiler.class);

    private String baseReportsPath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath().concat("/WEB-INF/classes/report/");
    
	@Override
	public void afterPropertiesSet() throws Exception {
		compileReport();
	}
	
	public void compileReport() throws Exception {
		File baseFileReportsPath = null;
		try {
			baseFileReportsPath = new ClassPathResource(baseReportsPath).getFile();
		} catch (IOException e) {
			LOGGER.error("Directory Report Failure", e);
		}		
		File[] baseFileReportsPathList = baseFileReportsPath.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String name) {				
				if(name.endsWith(".jrxml")) 
					return true;				
				return false;
			}
		});
		for(File templateFile : baseFileReportsPathList) {
	        compileReport(templateFile);
		}		
	}

    /**
     * Compile the report and generates a binary version of it
     * @param jasperDesign The report design
     * @return JasperReport
     */
    private JasperReport compileReport(File templateFile){
		JasperDesign jasperDesign = loadTemplate(templateFile);
        JasperReport jasperReport = null;
        try {
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
        } catch (JRException e) {
        	LOGGER.error("Compile Report Failure : "+baseReportsPath, e);
        }
        return(jasperReport);
    }
	
	/**
     * Load the template (defined by templatePath) and return a JasperDesign object representing the template
     * @return JasperDesign
     */
    private JasperDesign loadTemplate(File templateFile){
        JasperDesign jasperDesign = null;
        if(templateFile.exists()){
            try {
                jasperDesign = JRXmlLoader.load(templateFile);
            } catch (JRException e) {
            	LOGGER.error("Design Report Failure : "+baseReportsPath, e);
            }
            System.setProperty("jasper.reports.compile.temp", templateFile.getParent());
        }
        else
        	LOGGER.error("Error, the file dont exists");
        return(jasperDesign);
    }

	public String getBaseReportsPath() {
		return baseReportsPath;
	}

	public void setBaseReportsPath(String baseReportsPath) {
		this.baseReportsPath = baseReportsPath;
	}

}
