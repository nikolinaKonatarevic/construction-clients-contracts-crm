package com.Gradjevinsko_preduzece.service_imp;

import com.Gradjevinsko_preduzece.entity.ConstructionCompany;
import com.Gradjevinsko_preduzece.exception.NotFoundException;
import com.Gradjevinsko_preduzece.mapper.ConstructionCompanyMapper;
import com.Gradjevinsko_preduzece.record.ConstructionCompanyRecord;
import com.Gradjevinsko_preduzece.repository.ConstructionCompanyRepository;
import com.Gradjevinsko_preduzece.service.IConstructionCompanyService;

import java.util.List;

public class ConstructionCompanyService implements IConstructionCompanyService {

    private ConstructionCompanyMapper constructionCompanyMapper;
    private ConstructionCompanyRepository constructionCompanyRepository;

    public ConstructionCompanyService(ConstructionCompanyRepository constructionCompanyRepository,
                                      ConstructionCompanyMapper constructionCompanyMapper) {
        this.constructionCompanyRepository = constructionCompanyRepository;
        this.constructionCompanyMapper = constructionCompanyMapper;
    }

    @Override
    public List<ConstructionCompanyRecord> getAllConstructionCompanies() {
        List<ConstructionCompany> companies = constructionCompanyRepository.findAll();
        if (companies.isEmpty()) {
            throw new NotFoundException("ConstructionCompanyService getAllConstructionCompanies() :: No companies found");
        }
        return  companies.stream().map(constructionCompanyMapper::companyToCompanyRecord).toList();
    }
}
