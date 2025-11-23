package org.learn.services;

import java.util.List;

import org.learn.dto.DtoStudent;
import org.learn.dto.DtoSudentIU;
import org.learn.entities.Student;

public interface IStudentService {

    public DtoStudent saveStudent(DtoSudentIU student);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);
    public void deleteStudentById(Long id);
    public Student updateStudent(Long id, Student student);

}
