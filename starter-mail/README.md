# Configuration for other 'real' smtp
For this project I generated a fake one at: https://mailtrap.io/

## Gmail
application.properties:

    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=<login user to smtp server>
    spring.mail.password=<login password to smtp server>
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true

[Configure Gmail](https://support.google.com/mail/answer/7104828?hl=en&rd=3&visit_id=637398907905631279-3666777523)

Note that the password for your account should not be an ordinary password, but an application password generated for your google account.

[Application password](https://support.google.com/accounts/answer/185833)

## Amazon SES Service
application.properties:

    spring.mail.host=email-smtp.us-west-2.amazonaws.com
    spring.mail.username=username
    spring.mail.password=password
    spring.mail.properties.mail.transport.protocol=smtp
    spring.mail.properties.mail.smtp.port=25
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    spring.mail.properties.mail.smtp.starttls.required=true

Note that Amazon requires you to verify your credentials before using them.

[Verify credentials](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/verify-email-addresses.html)