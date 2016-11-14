package salaryhtmlreport.mailreport;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailSender {
    private final String host;
    private JavaMailSenderImpl mailSender;

    public MailSender(String host) {
        this.host = host;
        mailSender = new JavaMailSenderImpl();
    }

    private MimeMessage genereteMessage(String recipients, String report) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);
        helper.setText(report, true);
        helper.setSubject("Monthly department salary report");
        return message;
    }

    public void sendMessage(String recipients, String report) throws MessagingException {
        mailSender.setHost(host);
        MimeMessage message = genereteMessage(recipients, report);
        mailSender.send(message);
    }


}
