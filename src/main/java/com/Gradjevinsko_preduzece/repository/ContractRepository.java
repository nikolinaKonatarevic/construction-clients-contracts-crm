package com.Gradjevinsko_preduzece.repository;

import com.Gradjevinsko_preduzece.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
