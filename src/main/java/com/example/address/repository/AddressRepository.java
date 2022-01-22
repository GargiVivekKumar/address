package com.example.address.repository;

import com.example.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    //@Query("SELECT emp FROM Address emp WHERE emp.empId =?")
     Optional<Address> findByEmpId(Long empId);

}
