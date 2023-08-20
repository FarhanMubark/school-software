package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.DTO.AddressDTO;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.AddressRepository;
import com.example.school_management_software.Repository.TeacherRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;


    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null){
            throw new ApiException("No Teacher found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(),addressDTO.getBuilding_number(),teacher);

        addressRepository.save(address);
    }

    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);


        if (address==null){
            throw new ApiException("No address find with this Id");
        }

    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuilding_number(addressDTO.getBuilding_number());
        addressRepository.save(address);
    }

    public Address getAddressbyId(int id){
        Address address = addressRepository.findAddressById(id);

        if (address==null){
            throw new ApiException("No address find with this Id");
        }

        return address;

    }
}
