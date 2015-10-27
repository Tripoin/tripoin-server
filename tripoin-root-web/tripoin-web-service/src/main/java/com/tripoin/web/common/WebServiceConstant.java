package com.tripoin.web.common;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class WebServiceConstant {

	private static final String HTTP_LOAD = "/load";
	private static final String HTTP_SAVE = "/save";
	private static final String HTTP_UPDATE = "/update";
	/*private static final String HTTP_DELETE = "/delete";*/
	
	public static final String HTTP_ONLY = "HttpOnly";
	
	public static final String HTTP_CONNECTION = "/connection";	
	public static final String HTTP_LOGIN = "/login";	
	public static final String HTTP_LOGIN_MENU = "/login-menu";
	public static final String HTTP_PROFILE = "/profile".concat(HTTP_LOAD);
	public static final String HTTP_PROFILE_SAVE = "/profile".concat(HTTP_UPDATE);
	public static final String HTTP_PASSWORD_UPDATE = "/password".concat(HTTP_UPDATE);
	public static final String HTTP_AVAILABILITY = "/availability".concat(HTTP_LOAD);
	public static final String HTTP_CATEGORY = "/category".concat(HTTP_LOAD);
	public static final String HTTP_PRODUCT = "/product".concat(HTTP_LOAD);
	public static final String HTTP_USER = "/user".concat(HTTP_LOAD);
	public static final String HTTP_USER_SAVE = "/user".concat(HTTP_SAVE);
	public static final String HTTP_USER_UPDATE = "/user".concat(HTTP_UPDATE);
	public static final String HTTP_PRODUCT_SAVE = "/product".concat(HTTP_SAVE);

}
