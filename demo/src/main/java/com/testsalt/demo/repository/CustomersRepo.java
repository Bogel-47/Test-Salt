package com.testsalt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.testsalt.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomersRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(long id);

    @Query("SELECT c FROM Customer c WHERE c.status = 'Aktif'")
    List<Customer> findByStatus();

}
