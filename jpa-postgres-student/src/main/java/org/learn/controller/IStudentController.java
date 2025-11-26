package org.learn.controller;

import java.util.List;

import org.learn.dto.DtoStudent;
import org.learn.dto.DtoSudentIU;


public interface IStudentController {

    public DtoStudent saveStudent(DtoSudentIU dtoStudent);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);
    public void deleteStudentById(Long id);
    public DtoStudent updateStudent(Long id, DtoSudentIU dtoSudentIU);
}
