package com.robknox.studentroster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robknox.studentroster.models.Address;
import com.robknox.studentroster.repositories.AddressRepository;

@Service
public class AddressService {
	private AddressRepository addressRepository;
	
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	// returns all the addresses
	public List<Address> allAddresses() {
		return addressRepository.findAll();
	}
	
	// creates an address
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}
}
