package com.example.lab.repositories;

import com.example.lab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Get all customers for a given course
    List<Customer> findByCourseNameIgnoreCase(String name);

    // Get all customers in a given town for a given course
    List<Customer> findByTownAndCourseNameIgnoreCase(String town, String name);

    // Get all customers over a certain age in a given town for a given course
    List<Customer> findByAgeGreaterThanAndTownAndCourseNameIgnoreCase(int age, String town, String name);

}
