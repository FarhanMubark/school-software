package com.example.school_management_software.Repository;

import com.example.school_management_software.Model.Course;
import com.example.school_management_software.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {


    Course findCourseById(Integer id);

//    @Query("SELECT t.name FROM Teacher t JOIN t.course c WHERE c.courseId = :courseId")
//    Course findCourseByIdAndGetTeacherName(Integer courseId);

}
