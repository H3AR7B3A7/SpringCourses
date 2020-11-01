package be.dog.d.steven.xmlconfiguration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employee {

    private String first;
    private String last;
    private Date birthDate;
    private Double salary;
    private String position;
    private Department department;

    public Employee(){

        final Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("Employee beans were configured !!!");

    }
}
