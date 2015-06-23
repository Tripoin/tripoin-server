package com.tripoin.core.dto;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class GeneralConnectionDTO {

	private String response_code;

	private String response_msg;

	private String result;

	public String getResponse_code() {
		return response_code;
	}

	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}

	public String getResponse_msg() {
		return response_msg;
	}

	public void setResponse_msg(String response_msg) {
		this.response_msg = response_msg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "GeneralDTO [response_code=" + response_code + ", response_msg="
				+ response_msg + ", result=" + result + "]";
	}
}
