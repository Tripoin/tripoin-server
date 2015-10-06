package com.tripoin.util.mail.impl;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.tripoin.util.mail.ICoreMailSender;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class CoreMailSenderImpl implements ICoreMailSender {
	
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMailContent(String from, String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);	
	}

}
