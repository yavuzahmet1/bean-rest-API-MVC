package org.learn.controller.impl;

import java.util.List;

import org.learn.controller.IStudentController;
import org.learn.dto.DtoStudent;
import org.learn.dto.DtoStudentIU;
import org.learn.services.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


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
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudent) {
        return studentService.saveStudent(dtoStudent);
    }

    @GetMapping(path = "/all")
    @Override
    @ResponseBody
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/all/{id}")
    @Override
    @ResponseBody
    public DtoStudent getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

   
    @PutMapping(path = "/update/{id}")
    @Override
    @ResponseBody
    public DtoStudent updateStudent(@PathVariable Long id, @RequestBody DtoStudentIU dtoStudentIU) {
       return studentService.updateStudent(id, dtoStudentIU);
    }

}
