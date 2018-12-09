package struts2int;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Session.*;
import javax.mail.internet.*;

import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;


public class ForgotAction extends ActionSupport{
	private static String email;
	@Override
	public void validate() {
		if(email.length()<1)
			addFieldError("email", "email cant be blank");
		
		}
	public String execute(){

		final String user = "";// change accordingly
		final String password = "";// change accordingly

		String to = email;// change accordingly

		// Get the session object
		/*Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");*/
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
	     props.setProperty("mail.smtp.host", "smtp.gmail.com");
	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
	     props.setProperty("mail.smtp.port", "465");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.debug", "true");
	     props.put("mail.store.protocol", "pop3");
	     props.put("mail.transport.protocol", "smtp");
	    

		Session s = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(s);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("ramu");
			org.hibernate.Session session1=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
			Query query= session1.createQuery("from User where email=:i");
			  query.setString("i",email);
			  String passwd ;
			  List<User> list=query.list();
			  Iterator<User> i=list.iterator();
			  while(i.hasNext())
			  {
				  User u=i.next();
				   passwd=u.getPassword();
			message.setText("This is simple program of sending email using JavaMail API"+passwd);
			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");
			  }

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}