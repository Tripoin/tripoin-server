package com.tripoin.web.servlet;

import com.vaadin.server.SystemMessages;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author xpoft
 */
public interface SpringSystemMessagesProvider extends Serializable
{
    public SystemMessages getSystemMessages(Locale locale);
}
