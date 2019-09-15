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
	public SendMail(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException  {
		// email send to 
				String to  = request.getParameter("uemail");
				
				String cc= " waeal.obidallah@gmail.com";
		        // email sedt form
				String from= " titaniumx@Titanuim.com";
				
				
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
					msg.setSubject("Titanuim x - Validate Your Account");
					msg.setText(" Part of the code is done. i used my SMTP but do we need to configue smtp server on the loaclhost "
							+ "Please click this link: http://www.waealobidallah.com/verify?user=someone");
					msg.setFrom(new InternetAddress(from,
							"Waeal"));
					msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
							to));
					msg.setRecipient(Message.RecipientType.CC, new InternetAddress(
							cc));

					Transport.send(msg);
				} catch (MessagingException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Finished.");
			}

		// TODO Auto-generated constructor stub
	

	
}
