package com.Gradjevinsko_preduzece.service;

import com.Gradjevinsko_preduzece.record.ConstructionCompanyRecord;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IConstructionCompanyService {

    public List<ConstructionCompanyRecord> getAllConstructionCompanies();
    public ConstructionCompanyRecord getCompanyById(Long id);
}
