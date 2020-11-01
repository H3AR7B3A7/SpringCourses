package be.dog.d.steven.xmlconfiguration;

import be.dog.d.steven.xmlconfiguration.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XmlConfiguration {

    public static void main(String[] args) {

        SpringApplication.run(XmlConfiguration.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/app-context.xml");
        System.out.println("app-context loaded...");

        System.out.println("empRec1:");
        Employee empRec1 = (Employee) context.getBean("empRec1");
        System.out.printf("%s %s%n", empRec1.getFirst(), empRec1.getLast());
        System.out.println(empRec1.getDepartment().getDepartmentName());

        System.out.println("empRec2:");
        Employee empRec2 = (Employee) context.getBean("empRec2");
        System.out.printf("%s %s%n", empRec2.getFirst(), empRec2.getLast());
        System.out.println(empRec2.getDepartment().getDepartmentName());
    }

}
