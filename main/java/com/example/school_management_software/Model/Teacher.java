package com.example.school_management_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String name;
    @NotNull
    @Column(columnDefinition = "int", nullable = false)
    private Integer age;
    @Email
    @NotEmpty
    private String email;
    @Column(columnDefinition = "int",nullable = false)
    @NotNull
    private Integer salary;
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.DETACH, mappedBy = "teacher")
    private Address address;
}
