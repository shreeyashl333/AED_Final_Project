/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EmailUtility;


import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
    import java.util.Random;



import javax.swing.*;
import java.awt.*;

/**
 * 
 * /**
 *
 * @author shree
 */
public class EmailUtility {
    private Properties props;
    private final String adminEmail="inamdar.chaitanya6398@gmail.com";
    private final String adminPaswrd="jiihtcrzkzsbfcnt";
    
    public EmailUtility() {
        loadProperties();
    }
    
    public void loadProperties(){
        props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
    }
    

   

     
      
   

    
    public void sendMail(String receiverEmail,String subject,String message){
        
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(adminEmail,adminPaswrd);
            }
        });
        
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            String to = receiverEmail;
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            // addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject(subject + timeStamp);
            msg.setSentDate(new Date());
            msg.setText(message);
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
    
    public void sendOTPMail(String receiverEmail,String subject,String message,String Otp){
        
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(adminEmail,adminPaswrd);
            }
        });
        
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            String to = receiverEmail;
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            // addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject(subject + timeStamp);
            msg.setSentDate(new Date());
            msg.setText(message + " " + Otp);
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
    
    
    public char[] createOtp()
    {
        String numbers = "1234567890";
      Random random = new Random();
      char[] otp = new char[6];

      for(int i = 0; i< 6 ; i++) {
         otp[i] = numbers.charAt(random.nextInt(numbers.length()));}
      return otp;
    
    }
    
}