package org.learn.controller;

import java.util.List;

import org.learn.dto.DtoStudent;
import org.learn.dto.DtoSudentIU;
import org.learn.entities.Student;

public interface IStudentController {

    public DtoStudent saveStudent(DtoSudentIU dtoStudent);
    public List<DtoStudent> getAllStudents();
    public Student getStudentById(Long id);
    public void deleteStudentById(Long id);
    public Student updateStudent(Long id, Student student);
}
