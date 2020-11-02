package be.dog.d.steven.startermail.controller;

import be.dog.d.steven.startermail.mail.Mail;
import be.dog.d.steven.startermail.mail.MailConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MailFormController {

    private final MailConfiguration mailConfiguration;

    @GetMapping("/")
    public String mailForm(Model model) {
        model.addAttribute("mail", new Mail());
        return "index";
    }

    @PostMapping("/")
    public String mailSubmit(@ModelAttribute("mail") Mail mail, Model model) {
        model.addAttribute("mail", mail);

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


        return "index";
    }

}
