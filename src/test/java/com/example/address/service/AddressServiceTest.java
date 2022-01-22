package com.example.address.service;

import com.example.address.model.Address;
import com.example.address.repository.AddressRepository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;
    private Long empId = 3L;
    private AddressService addressService;
    private Address address;

    @Before
    public void beforeSetUp(){
        addressService = new AddressService(addressRepository);
        address = new Address();
        address.setId(1L);
        address.setEmpId(3L);
        address.setHouseNumber("W-11");
        address.setStreet("Bockhemheimer Strasse");
        address.setCity("Frankfurt");
        address.setPinCode(60313);
    }

    @Test
    public void testGetAddress(){
        Mockito.when(addressRepository.findByEmpId(empId)).thenReturn(Optional.of(address));
        Address result=addressService.getAddress(empId);
        Assert.assertEquals(result.getId(),address.getId());
        Assert.assertEquals(result.getStreet(),"Bockhemheimer Strasse");
        Mockito.verify(addressRepository,Mockito.times(1)).findByEmpId(3L);
    }


}
