package be.dog.d.steven.xmlconfiguration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
public class Department {

    private Integer departmentNumber;
    private String departmentName;

    public Department(){

        final Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("Department beans were configured !!!");

    }
}
