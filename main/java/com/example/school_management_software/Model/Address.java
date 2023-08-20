package com.example.school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "area should not be empty")
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String area;
    @NotEmpty(message = "street not null")
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String street;
    @NotNull(message = "building number not null")
    @Column(columnDefinition = "int", nullable = false)
    private Integer building_number;
    @OneToOne
    @JsonIgnore
    @MapsId
    private Teacher teacher;

}
