package com.pc.service;

import com.pc.entity.Address;
import com.pc.exception.AddressException;

public interface AddressService {
	public Address addAddress(Address address)throws AddressException ;
	public Address deleteAddress(Integer addressId) throws AddressException ;
}
