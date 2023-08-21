package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.Model.Course;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.CourseRepository;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course course1 = courseRepository.findCourseById(id);

        if (course1==null){
            throw new ApiException("Course with this id " + id +"Not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course==null){
            throw new ApiException("Course with this id " + id +" Not found");
        }

        courseRepository.delete(course);
    }

    public void assginTeacherToCourse(Integer teacher_id, Integer course_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if (teacher == null || course == null){
            throw new ApiException("can not assign");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String getTeacherName(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);

        if (course==null){
            throw new ApiException("Course with this id " + courseId +" Not found");
        }

        return course.getTeacher().getName();

    }


}
