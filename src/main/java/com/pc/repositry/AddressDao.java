package com.pc.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pc.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
