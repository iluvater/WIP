package dev.sendmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailService {
	
	private Properties mailServerProperties;
	private Session getMailSession;
	private MimeMessage generateMailMessage;
	
	public void SendMail(){
		//Set SErver Properties
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");	
		try {
			//Get Mail Session
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ture.kuesener@gmx.de"));
			//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
			generateMailMessage.setSubject("Greetings from Crunchify..");
			String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
			generateMailMessage.setContent(emailBody, "text/html");
			
			
			//Sending Mail
			Transport transport = getMailSession.getTransport("smtp");
			 
			transport.connect("smtp.gmail.com", "webshop.run4fun@gmail.com", "Run4Fun99");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
