package com.ecommerce.customer.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.customer.model.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    List<Customer> findById(int id);
}
