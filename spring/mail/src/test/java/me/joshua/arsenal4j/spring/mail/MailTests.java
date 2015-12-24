package me.joshua.arsenal4j.spring.mail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailTests extends AbstractSpringMailTests {

	@Autowired
	private MailSender mailSender;
	@Autowired
	private SimpleMailMessage templateMessage;
	@Value("${mail.to}")
	private String toAddress;

	@Test
	public void test() {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(toAddress);
		msg.setText("Hello world!");
		mailSender.send(msg);
	}
}
