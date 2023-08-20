package com.example.school_management_software.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    private String area;
    private String street;
    private Integer building_number;

}
