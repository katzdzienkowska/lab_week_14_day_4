package com.example.lab.components;

import com.example.lab.models.Booking;
import com.example.lab.models.Course;
import com.example.lab.models.Customer;
import com.example.lab.repositories.BookingRepository;
import com.example.lab.repositories.CourseRepository;
import com.example.lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Coding", "Edinburgh", 5);
        courseRepository.save(course1);
        Course course2 = new Course("Weaving", "Lodz", 4);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Kat", "Edinburgh", 34, course1);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Oskar", "Lodz", 12, course2);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Raff", "Glasgow", 33, course1);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("2022-05-01", customer1, course1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("2022-06-01", customer2, course2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("2022-07-01", customer3, course1);
        bookingRepository.save(booking3);

    }

}
