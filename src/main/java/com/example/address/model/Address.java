package com.example.address.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
@Data
public class Address {

    @Id
    private Long id;

    private Long empId;

    private String houseNumber;

    private String street;

    private String city;

    private int pinCode;
}
