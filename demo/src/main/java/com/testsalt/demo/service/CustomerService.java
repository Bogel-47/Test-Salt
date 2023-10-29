package com.testsalt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testsalt.demo.repository.CustomersRepo;

@Service
public class CustomerService {
    @Autowired CustomersRepo customersRepo;
}
