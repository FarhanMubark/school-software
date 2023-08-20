package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacer(int id, Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if (teacher1==null){
            throw new ApiException("No teacher find with this Id");
        }

        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setEmail(teacher.getEmail());

        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(int id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher==null){
            throw new ApiException("No teacher find with this Id");
        }

        teacherRepository.delete(teacher);

    }

 public Teacher getbyId(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);


     if (teacher==null){
         throw new ApiException("No teacher find with this Id");
     }

     return teacher;
 }
}
