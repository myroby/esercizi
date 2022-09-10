package com.esercizi.demo.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Student {

    // birthdate format = yyyy-MM-dd
    private final String firstname, lastname, birthdate;

    private final int[] grades;

    public Student(String firstname, String lastname, String birthdate, int... grades) {
        if (!isDateValid(birthdate)) throw new IllegalArgumentException("Birthdate not valid.");
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.grades = grades;
    }

    public int getAge() {
        LocalDate date = LocalDate.parse(this.birthdate);
        LocalDate now = LocalDate.now();
        return Period.between(date, now).getYears();
    }

    public double getAvgGrade() {
        return (double) Arrays.stream(grades).sum() / grades.length;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    @Override
    public String toString() {
        return "Student [birthdate=" + birthdate + ", firstname=" + firstname + ", grades=" + Arrays.toString(grades)
                + ", lastname=" + lastname + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (birthdate == null) {
            if (other.birthdate != null)
                return false;
        } else if (!birthdate.equals(other.birthdate))
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        return true;
    }

    public static boolean isDateValid(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Student student = new Student("firstname", "lastname", "1999-01-01", 19, 18);
        System.out.println(student.getAge());
        System.out.println(student.getAvgGrade());
    }

}
