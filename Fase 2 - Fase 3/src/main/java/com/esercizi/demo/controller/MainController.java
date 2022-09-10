package com.esercizi.demo.controller;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esercizi.demo.model.Student;
import com.esercizi.demo.response.StudentListResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@RestController
public class MainController {

  private List<Student> students = Collections.synchronizedList(new ArrayList<Student>());

  private final Gson gson = new Gson();
  
  @PostMapping("/createstudent")
  public ResponseEntity<String> createstudent(@RequestBody(required = true) String json) {
    HttpStatus status;
    try {
      Student student = this.gson.fromJson(json, Student.class);
      if (!Student.isDateValid(student.getBirthdate())) throw new IllegalArgumentException("Birthdate not valid.");
      status = addIfNotContains(student) ? HttpStatus.OK : HttpStatus.CONFLICT;
    } catch (JsonSyntaxException | IllegalArgumentException e) {
      status = HttpStatus.BAD_REQUEST;
    }
    return new ResponseEntity<String>(status);
  }
  
  @GetMapping("/getstudents")
  public ResponseEntity<String> getStudents() {
    String response = this.gson.toJson(new StudentListResponse(this.students));
    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  private boolean addIfNotContains(Student student) {
    synchronized(this.students) {
      if (!this.students.contains(student)) 
        return this.students.add(student);
    }
    return false;
  }

}
