package com.example.address.controller;

import com.example.address.dto.AddressDTO;
import com.example.address.model.Address;
import com.example.address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
   private ModelMapper modelMapper;

    @GetMapping(value = "/address/{empId}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable("empId") Long id){
        //convert entity to dto
        AddressDTO addressDTO =modelMapper.map(addressService.getAddress(id),AddressDTO.class);
        return ResponseEntity.ok().body(addressDTO);
    }

    @PostMapping(value="/address")
    public ResponseEntity<AddressDTO> insertAddress(@RequestBody AddressDTO addressDTO){
        Address address1 = new Address();
        address1.setCity(addressDTO.getCity());
        address1.setStreet(addressDTO.getStreet());
        address1.setPinCode(addressDTO.getPinCode());
        address1.setEmpId(addressDTO.getEmpId());
        address1.setHouseNumber(addressDTO.getHouseNumber());
        address1.setId(addressDTO.getId());
        Address address = addressService.saveAddress(address1);
        return new ResponseEntity<AddressDTO>(modelMapper.map(address, AddressDTO.class), HttpStatus.CREATED);

    }
}
