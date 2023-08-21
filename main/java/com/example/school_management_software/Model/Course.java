package com.example.school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Course Not Empty")
    @Column(columnDefinition = "varchar(12)", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id" , referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;
}
