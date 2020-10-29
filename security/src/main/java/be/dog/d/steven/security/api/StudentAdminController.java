package be.dog.d.steven.security.api;

import be.dog.d.steven.security.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("admin/api/v1/students")
public class StudentAdminController {

    // Fake dao
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "testStudent1"),
            new Student(2, "testStudent2"),
            new Student(3, "testStudent3")
    );

    // Method level authorization: hasRole, hasAnyRole, hasAuthority, hasAnyAuthority

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public  void registerStudent(@RequestBody Student student){
        System.out.println("registered " + student); // Placeholder
    }

    @DeleteMapping(path = "/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleted " + studentId); // Placeholder
    }

    @PutMapping(path = "/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student newStudent) {
        System.out.println("updated " + studentId + " to " + newStudent.getStudentName()); // Placeholder
    }
}
