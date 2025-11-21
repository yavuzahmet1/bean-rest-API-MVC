package org.learn.controller;

import java.util.List;

import org.learn.entities.Student;

public interface IStudentController {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
    public void deleteStudentById(Long id);
    public Student updateStudent(Long id, Student student);
}
