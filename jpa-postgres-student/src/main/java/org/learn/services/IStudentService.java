package org.learn.services;

import java.util.List;

import org.learn.dto.DtoStudent;
import org.learn.dto.DtoStudentIU;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);
    public void deleteStudentById(Long id);
    public DtoStudent updateStudent(Long id, DtoStudentIU dtoSudentIU);

}
