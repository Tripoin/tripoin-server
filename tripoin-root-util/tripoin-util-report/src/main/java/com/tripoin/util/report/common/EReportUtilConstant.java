
package com.tripoin.util.report.common;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EReportUtilConstant {

	REPORT_PDF(".pdf"),
	REPORT_EXCEL("*.xls"),
	REPORT_CSV(".csv");

	private String operator;
	private Integer operatorInteger;	
	
	private EReportUtilConstant(String operator){
		this.operator = operator ;
	}	
	
	private EReportUtilConstant(Integer operatorInteger){
		this.operatorInteger = operatorInteger ;
	}
	
	public String getString() {
		return operator;
	}

	public Integer getInt() {
		return operatorInteger;
	}

	@Override
	public String toString() {
		if(operator == null)
			return operatorInteger.toString();
		return operator;
	}
	
}
