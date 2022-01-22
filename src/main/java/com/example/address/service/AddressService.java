package com.example.address.service;

import com.example.address.config.Errors;
import com.example.address.model.Address;
import com.example.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    public Address getAddress(Long empId){
        //Optional<Address> address= addressRepository.findByEmpId(empId);
        /*if(address.isEmpty()){
            throw Errors.NOT_FOUND.asException();
        }*/
        //return address.get();
        return addressRepository.findByEmpId(empId)
                .orElseThrow( Errors.NOT_FOUND::asException);
    }
    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
}
