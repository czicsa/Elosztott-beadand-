package hu.meiit.integration;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import hu.meiit.model.EmailDetails;

public class SendEmailActivator {

    @Autowired
    private JavaMailSender mailSender;

    public @ResponsePayload ExecutionReport handleEmailSend(Message<EmailDetails> message) {
        EmailDetails details = message.getPayload();
        if (details == null) {
            return generateBadRequest("Payload?!");
        }

        try {
            MimeMessage Emessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(Emessage);
            helper.setTo("czicsa@gmail.com");
            helper.setSubject("Új autó!");
            helper.setText(details.getMessage(), true);
            mailSender.send(Emessage);
        } catch (Exception e) {
            generateBadRequest("Email sending failed!");
        }
        return new ExecutionReport(true, "Success!");
    }

    private ExecutionReport generateBadRequest(String cause) {
        return new ExecutionReport(false, cause);
    }
}