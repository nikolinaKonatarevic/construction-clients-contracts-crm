package com.Gradjevinsko_preduzece.repository;

import com.Gradjevinsko_preduzece.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
