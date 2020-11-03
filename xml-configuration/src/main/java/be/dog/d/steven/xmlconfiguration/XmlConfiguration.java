package be.dog.d.steven.xmlconfiguration;

import be.dog.d.steven.xmlconfiguration.config.BeanConfig;
import be.dog.d.steven.xmlconfiguration.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XmlConfiguration {

    public static void main(String[] args) {

        SpringApplication.run(XmlConfiguration.class, args);
        ApplicationContext xml_context = new ClassPathXmlApplicationContext("spring/app-context.xml");
        System.out.println("app-xml_context loaded...");

        /**
         * XML configuration
         */

        System.out.println("empRec1:");
        Employee empRec1 = (Employee) xml_context.getBean("empRec1");
        System.out.printf("%s %s%n", empRec1.getFirst(), empRec1.getLast());
        System.out.println(empRec1.getDepartment().getDepartmentName());
        System.out.println(empRec1.getBirthDate());
        System.out.println(empRec1.getSalary());

        System.out.println("empRec2:");
        Employee empRec2 = (Employee) xml_context.getBean("empRec2");
        System.out.printf("%s %s%n", empRec2.getFirst(), empRec2.getLast());
        System.out.println(empRec2.getDepartment().getDepartmentName());
        System.out.println(empRec2.getBirthDate());
        System.out.println(empRec2.getSalary());


        AnnotationConfigApplicationContext annotation_context = new AnnotationConfigApplicationContext();
        annotation_context.register(BeanConfig.class);
        annotation_context.refresh();

        /**
         * JavaConfig
         */

        System.out.println("empRec3:");
        Employee empRec3 = (Employee) annotation_context.getBean("empRec3");
        System.out.printf("%s %s%n", empRec3.getFirst(), empRec3.getLast());
        System.out.println(empRec3.getDepartment().getDepartmentName());
        System.out.println(empRec3.getBirthDate());
        System.out.println(empRec3.getSalary());
    }

}
