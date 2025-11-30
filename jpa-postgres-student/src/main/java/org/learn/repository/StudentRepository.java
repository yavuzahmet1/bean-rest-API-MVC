package org.learn.repository;

import java.util.List;
import java.util.Optional;

import org.learn.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value="select * from students.students",nativeQuery = true)
    List<Student> findAllStudents();
    @Query(value="from Student s where s.id=:studentId")  
    Optional<Student> findStudentById(Long studentId);

}
