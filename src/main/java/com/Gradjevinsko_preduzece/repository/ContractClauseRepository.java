package com.Gradjevinsko_preduzece.repository;

import com.Gradjevinsko_preduzece.entity.ContractClause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractClauseRepository extends JpaRepository<ContractClause, Long> {
}
