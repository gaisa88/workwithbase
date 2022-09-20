package com.workwithbase.repository;

import com.workwithbase.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c from Client c where c.phone = :phone")
    List findAllByName(String phone);

}
