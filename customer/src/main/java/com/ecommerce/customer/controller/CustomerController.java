package com.ecommerce.customer.controller;

import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getPelangganAll(){
        List<Customer> pelangganData = customerRepository.findAll();

        if(!pelangganData.isEmpty()){
            return new ResponseEntity<>(pelangganData,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Customer>> getPelangganById(@PathVariable("id") int id){
        List<Customer> pelangganData = customerRepository.findById(id);

        if(!pelangganData.isEmpty()){
            return new ResponseEntity<>(pelangganData,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/customer")
    public ResponseEntity<Customer> createPelanggan(@RequestBody Customer customer) {
        try {
            Customer _pelanggan = customerRepository.save(new Customer(customer.getNama(),customer.getHp()));
            return new ResponseEntity<>(_pelanggan, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updatePelanggan(@PathVariable("id") int id, @RequestBody Customer customer) {
        List<Customer> pelangganlData = customerRepository.findById(id);

        if (!pelangganlData.isEmpty()) {
            Customer _pelanggan = pelangganlData.get(0);
            _pelanggan.setNama(customer.getNama());
            _pelanggan.setHp(customer.getHp());
            return new ResponseEntity<>(customerRepository.save(_pelanggan), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<HttpStatus> deletePelanggan(@PathVariable("id") int id) {
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customer")
    public ResponseEntity<HttpStatus> deletePelangganAll() {
        try {
            customerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
