package be.dog.d.steven.xmlconfiguration.config;

import be.dog.d.steven.xmlconfiguration.model.Department;
import be.dog.d.steven.xmlconfiguration.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
public class BeanConfig {

    @Bean(name="empRec3")
    public Employee getEmployee(){

        Employee empRec3 = new Employee();
        empRec3.setFirst("Jane");
        empRec3.setLast("Doe");
            Calendar date = Calendar.getInstance();
            date.set(2000,Calendar.JANUARY,1);
        empRec3.setBirthDate(date.getTime());
        empRec3.setPosition("office worker");
        empRec3.setSalary(50000.0);
        empRec3.setDepartment(getDept3());

        return empRec3;
    }

    @Bean(name="dept3")
    public Department getDept3(){

        Department dept3 = new Department();
        dept3.setDepartmentNumber(3);
        dept3.setDepartmentName("human resources");

        return dept3;
    }
}
