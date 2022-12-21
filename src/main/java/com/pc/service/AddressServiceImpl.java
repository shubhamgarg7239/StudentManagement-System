package com.pc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.entity.Address;
import com.pc.exception.AddressException;
import com.pc.repositry.AddressDao;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao ;
	@Override
	public Address addAddress(Address address) throws AddressException  {
		if(address == null ) throw new AddressException("Address should not be null") ;
		return addressDao.save(address);
	}

	@Override
	public Address deleteAddress(Integer addressId) throws AddressException {
		Optional<Address> address =  addressDao.findById(addressId) ;
		if(address.isEmpty()) throw new AddressException("Address Not found with this Id") ;
		addressDao.delete(address.get());
		return address.get();
	}
	
}
