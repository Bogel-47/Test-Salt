package com.testsalt.demo.controller;

import com.testsalt.demo.model.Customer;
import com.testsalt.demo.repository.CustomersRepo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomersRepo customersRepo;

	@GetMapping("/all")
	public ModelAndView getAll() {
		List<Customer> customers = customersRepo.findByStatus();
		ModelAndView modelAndView = new ModelAndView("customers");
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}
	
    @GetMapping("/detail")
    public ModelAndView getId(@RequestParam Long id) {
        Customer customer = customersRepo.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

	@GetMapping("/add")
	public String addCustomer(){
		log.info("update to addcustomenr html");
		return "add-customer";
	}
	
	//only on postman
    @Transactional
    @PostMapping("/add_user")
    @ResponseBody
    public Customer create(@RequestBody Customer customer) {
        customersRepo.save(customer);
        return customer;
    }

	//only on postman
    @PutMapping("/update")
    @ResponseBody
    public Customer update(@RequestParam long id, @RequestBody Customer customer) {
        Customer customerExist = customersRepo.findById(id).orElse(null);
        if (customerExist == null) {
            return null;
        }

        customer.setCustId(customerExist.getCustId());
        customersRepo.save(customer);
        return customer;
    }

	//only on postman
    @PutMapping("/delete")
    @ResponseBody
    public String deletebyId(@RequestParam long id) {
        Customer customerExist = customersRepo.findById(id).orElse(null);
        if (customerExist == null) {
            return null;
        }

        customerExist.setStatus("Tidak Aktif");
        customersRepo.save(customerExist);
        return "customers";
    }
}
