package com.vacvn.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.vacvn.model.UserModel;


public class EmailUtility {
	
	private String host;
    private String port;
    private String user;
    private String pass;
 
    public EmailUtility(String host, String port, String user, String pass) {
		
		this.host = host;
		this.port = port;
		this.user = user;
		this.pass = pass;
	}

	public void sendEmail(String vaccinationScheduleId, UserModel recipient, String authEncoded) throws AddressException,
            MessagingException {
//    	System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
       
       
        String content = "Gửi [[name]],<br>"
                + "Vui lòng bấm vào link dưới để xác thức đăng ký:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">XÁC THỰC</a></h3>"
                + "Trận trọng cảm ơn,<br>"
                + "VACCINE VIET NAM.";
        content = content.replace("[[name]]", recipient.getFullName());
        String verifyURL = "http://localhost:8080/vacvn/api/vaccinationschedules/registry" + "?"
        		+ "vaccinationscheduleid=" + vaccinationScheduleId + 
        		"&userid=" + recipient.getId() +  
        		"&code=" + authEncoded;
         
        content = content.replace("[[URL]]", verifyURL);
        msg.setFrom(new InternetAddress(user));
        InternetAddress[] toAddresses = { new InternetAddress(recipient.getEmail())};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject("[VACVN] Vui lòng xác thực mẫu đăng ký");
        msg.setSentDate(new Date());
        msg.setContent(content, "text/html; charset=utf-8");;
 
        // sends the e-mail
        Transport.send(msg);
 
    }
    
    
}