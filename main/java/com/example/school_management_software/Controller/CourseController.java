package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.Model.Course;
import com.example.school_management_software.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
       return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse(" course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @RequestBody @Valid Course course){
        courseService.updateCourse(id, course);

        return ResponseEntity.status(200).body(new ApiResponse("course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse(" course deleted"));
    }

    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        courseService.assginTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign Done"));
    }

    @GetMapping("/get-teacher-course-id/{id}")
    public ResponseEntity getTeacherNameByCourse(@PathVariable int id){
        return ResponseEntity.status(200).body(new ApiResponse(courseService.getTeacherName(id)));
    }
}
