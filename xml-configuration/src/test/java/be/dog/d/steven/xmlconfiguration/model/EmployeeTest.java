package be.dog.d.steven.xmlconfiguration.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmployeeTest {
    @Test
    public void testConstructor() {
        Employee actualEmployee = new Employee();
        assertNull(actualEmployee.getDepartment());
        assertNull(actualEmployee.getSalary());
        assertNull(actualEmployee.getLast());
        assertEquals("Employee(first=null, last=null, birthDate=null, salary=null, position=null, department=null)",
                actualEmployee.toString());
        assertNull(actualEmployee.getFirst());
        assertNull(actualEmployee.getBirthDate());
        assertNull(actualEmployee.getPosition());
    }
}

