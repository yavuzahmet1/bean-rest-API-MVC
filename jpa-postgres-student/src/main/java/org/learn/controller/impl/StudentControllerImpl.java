package org.learn.controller.impl;

import org.learn.controller.IStudentController;
import org.learn.entities.Student;
import org.learn.services.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/api/students")
public class StudentControllerImpl implements IStudentController {

    private IStudentService studentService;

    public StudentControllerImpl(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/save")
    @Override
    @ResponseBody
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
