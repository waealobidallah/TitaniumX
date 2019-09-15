package controllers;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * SendMail.java
 * @authore Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 * 2014
 * Created on Oct 29, 2014 -  12:32:53 AM
 *
 */

/**
 * @author Waeal J.Obidallah
 * 
 */
public class SendMail {
	
	
			
	/**
	 * 
	 */
	public  SendMail(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException  {
		        
		        // email send to 
				String from  = request.getParameter("uemail");
				// get the name form the request 
				String uName = request.getParameter("uname");
				//get the phone 
				String uPhone = request.getParameter("uphone");
				// get the message 
				String uMessage= request.getParameter("umessage");
				
				String cc= " waeal.obidallah@gmail.com";
		        // email sedt form
				String to= " titaniumx@waealobidallah.com";
				
				
				// the host where you send the emails
				String host= "mail.waealobidallah.com";
				
				// get system properies		
				Properties props = new Properties();
				// my email server
				props.setProperty("mail.host", host);
				props.setProperty("mail.smtp.port", "25");
				props.setProperty("mail.smtp.auth", "true");

				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"admin@waealobidallah.com", "waeal123");
					}
				};
		        
				Session session = Session.getDefaultInstance(props, auth);

				Message msg = new MimeMessage(session);

				try {
					msg.setSubject("Titanuim x - contact me ");
					msg.setContent("<b>User name is " + uName + "</b>" +
							  "<br><b>User phone is " + uPhone + "</b>" +
							  "<br> <b> User Email is " + from + "</b>" +
							   "<br> <b>User Message :" +  uMessage +"</b>" 
							, "text/html");
					msg.setFrom(new InternetAddress(from,
							"Waeal"));
					msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
							to));
					msg.setRecipient(Message.RecipientType.CC, new InternetAddress(
							cc));

					Transport.send(msg);
				} catch (MessagingException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					System.out.println(" was not able to send");
					e.printStackTrace();
				}

				System.out.println("Finished.");
			}

		// TODO Auto-generated constructor stub
	

	
}
