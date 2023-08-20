package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;

import com.example.school_management_software.Model.Teacher;

import com.example.school_management_software.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added"));
    }

    @PutMapping("/update-teacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @Valid Teacher teacher){
        teacherService.updateTeacer(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }

    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity getTeacherInfo(int id){
        Teacher teacher = teacherService.getbyId(id);
        return ResponseEntity.status(200).body(teacher);
    }

}
