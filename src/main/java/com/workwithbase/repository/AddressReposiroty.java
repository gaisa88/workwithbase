package com.workwithbase.repository;

import com.workwithbase.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressReposiroty extends JpaRepository<Address, Long> {

}
