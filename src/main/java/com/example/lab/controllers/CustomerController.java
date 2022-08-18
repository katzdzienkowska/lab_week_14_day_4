package com.example.lab.controllers;

import com.example.lab.models.Course;
import com.example.lab.models.Customer;
import com.example.lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (age != null & town != null & name != null) {
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndCourseNameIgnoreCase(age, town, name), HttpStatus.OK);
        }
        else if (town != null && name != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndCourseNameIgnoreCase(town, name), HttpStatus.OK);
        }
        else if (name != null) {
            return new ResponseEntity<>(customerRepository.findByCourseNameIgnoreCase(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
