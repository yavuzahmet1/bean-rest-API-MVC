package org.learn.services.impl;

import java.util.List;
import java.util.Optional;

import org.learn.entities.Student;
import org.learn.repository.StudentRepository;
import org.learn.services.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
        
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
         Optional<Student> optional= studentRepository.findById(id);
         if (optional.isPresent()) {
                return optional.get(); 
         }
         return optional.orElse(null);
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
