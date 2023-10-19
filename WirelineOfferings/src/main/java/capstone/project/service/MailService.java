package capstone.project.service;

import lombok.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;

@RestController
public class MailService {
	
    private final JavaMailSender javaMailSender;

	 

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

 

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

 

        javaMailSender.send(message);
    }

 

}


