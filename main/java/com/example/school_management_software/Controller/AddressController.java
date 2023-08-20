package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.DTO.AddressDTO;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/get-address")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(addressService.getAll());
    }

    @PostMapping("/add-address")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse(" address added"));

    }

    @PutMapping("/update-address")
    public ResponseEntity updateAddress(AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address Updated"));
    }

    @DeleteMapping("/delete-address/{id}")
    public ResponseEntity deleteAddress(int id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address Deleted"));
    }

    @GetMapping("get-address-by-id/{id}")
    public ResponseEntity getAddressById(@PathVariable int id){
       Address address = addressService.getAddressbyId(id);
        return ResponseEntity.status(200).body(address);
    }
}
