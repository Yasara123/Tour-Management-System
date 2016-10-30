/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.exampleCustomer;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Cassendra
 */
@Stateless
public class EmailSessionBean {
//private DBChecker db = new DBChecker();
    private int port = 465;
private String host = "smtp.gmail.com";
private String from = "email@gmail.com";
private boolean auth = true;
public final String username = "dreamtourspvt@gmail.com";
private final String pass = "cse123db";
private Protocol protocol = Protocol.SMTPS;
private boolean debug = true;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void sendEmail(String to, String subject,String body) throws MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.user",username);
props.put("mail.smtp.host", host);
props.put("mail.smtp.port", port);
 props.put("mail.smtp.socketFactory.port",port);
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
switch (protocol) {
    case SMTPS:
        props.put("mail.smtp.ssl.enable", true);
        break;
    case TLS:
        props.put("mail.smtp.starttls.enable", true);
        break;
}
Authenticator authenticator = null;
if (auth) {
    props.put("mail.smtp.auth", true);
    authenticator = new Authenticator() {
        private PasswordAuthentication pa = new PasswordAuthentication(username, pass);
        @Override
                public PasswordAuthentication getPasswordAuthentication() {
            return pa;
        }
    };
   
}
Session session = Session.getInstance(props, authenticator);
session.setDebug(debug);
MimeMessage message = new MimeMessage(session);
Multipart multipart = new MimeMultipart("alternative");
MimeBodyPart textPart = new MimeBodyPart();
String textContent = body;
textPart.setText(textContent);
multipart.addBodyPart(textPart);

try {
    message.setFrom(new InternetAddress(from));
    InternetAddress[] address = {new InternetAddress(to)};
    message.setRecipients(Message.RecipientType.TO, address);
    message.setSubject(subject);
    message.setSentDate(new Date());
    message.setContent(multipart);
    Transport transport = session.getTransport("smtps");
            transport.connect(host, from, pass);
            transport.send(message);
            transport.close();
    //Transport.send(message);
    System.out.println("Done");
} catch (MessagingException ex) {
    ex.printStackTrace();
}
    }
}
