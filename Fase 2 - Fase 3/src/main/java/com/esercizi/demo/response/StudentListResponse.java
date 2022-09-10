package com.esercizi.demo.response;

import java.util.ArrayList;
import java.util.List;

import com.esercizi.demo.model.Student;

public class StudentListResponse {

    private List<Student> students;

    public StudentListResponse(List<Student> students) {
        this.students = new ArrayList<Student>(students);
    }
    
}
