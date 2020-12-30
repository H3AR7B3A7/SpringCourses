package be.dog.d.steven.xmlconfiguration.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DepartmentTest {
    @Test
    public void testConstructor() {
        Department actualDepartment = new Department();
        assertNull(actualDepartment.getDepartmentName());
        assertNull(actualDepartment.getDepartmentNumber());
        assertEquals("Department(departmentNumber=null, departmentName=null)", actualDepartment.toString());
    }
}

