package org.learn.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.learn.dto.DtoStudent;
import org.learn.dto.DtoSudentIU;
import org.learn.entities.Student;
import org.learn.repository.StudentRepository;
import org.learn.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public DtoStudent saveStudent(DtoSudentIU dtoStudent) {
        Student student=new Student();
        BeanUtils.copyProperties(dtoStudent, student);
        Student savedStudent= studentRepository.save(student);
        DtoStudent dtoSavedStudent=new DtoStudent();
        BeanUtils.copyProperties(savedStudent, dtoSavedStudent);
        return dtoSavedStudent;
        
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoStudentsList= new ArrayList<>();
        List<Student> students= studentRepository.findAll();
        for (Student student : students) {
            DtoStudent dtoStudent=new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoStudentsList.add(dtoStudent);
        }
        return dtoStudentsList;
       
    }

    @Override
    public DtoStudent getStudentById(Long id) {
        DtoStudent dtoStudent=new DtoStudent();
         Optional<Student> optional= studentRepository.findById(id);
         if (optional.isPresent()) {
                Student student= optional.get();
                BeanUtils.copyProperties(student, dtoStudent);
                return dtoStudent;
         }
         return null;
    }

    @Override
    public void deleteStudentById(Long id) {
        Student dbStudent=getStudentById(id);
        if (dbStudent!=null) {
             studentRepository.delete(dbStudent);
        }
       
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student dbStudent =getStudentById(id);
        if (dbStudent!=null) {
            dbStudent.setFirstName(student.getFirstName());
            dbStudent.setLastName(student.getLastName());
            dbStudent.setBirthOfDate(student.getBirthOfDate());
            return studentRepository.save(dbStudent);
        }
        return null;    
    }

}
