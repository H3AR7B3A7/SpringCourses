package be.dog.d.steven.security.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Student {

    private final Integer studentId;
    private final String studentName;

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}
