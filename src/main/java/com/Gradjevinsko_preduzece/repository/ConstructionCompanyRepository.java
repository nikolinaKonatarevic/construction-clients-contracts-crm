package com.Gradjevinsko_preduzece.repository;

import com.Gradjevinsko_preduzece.entity.ConstructionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionCompanyRepository extends JpaRepository<ConstructionCompany, Long> {
}
