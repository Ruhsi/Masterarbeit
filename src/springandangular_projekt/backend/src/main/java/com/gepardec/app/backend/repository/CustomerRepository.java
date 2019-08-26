package com.gepardec.app.backend.repository;

import com.gepardec.app.backend.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
