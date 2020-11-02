package be.dog.d.steven.startermail.api;

import be.dog.d.steven.startermail.mail.Mail;
import be.dog.d.steven.startermail.mail.MailConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@AllArgsConstructor
public class MailApiController {

    private final MailConfiguration mailConfiguration;

    @PostMapping("/api/v1/mail")
    public void sendMail(@RequestBody Mail mail, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Mail is not valid");
        }

        // Configure mailbox
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.mailConfiguration.getHost());
        mailSender.setPort(this.mailConfiguration.getPort());
        mailSender.setUsername(this.mailConfiguration.getUsername());
        mailSender.setPassword(this.mailConfiguration.getPassword());

        // Create mail
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mail.getEmail());
        mailMessage.setTo("mail@mailtrap.com");
        mailMessage.setSubject("New mail from:" + mail.getName());
        mailMessage.setText(mail.getBody());

        // Send mail
        mailSender.send(mailMessage);
    }
}
