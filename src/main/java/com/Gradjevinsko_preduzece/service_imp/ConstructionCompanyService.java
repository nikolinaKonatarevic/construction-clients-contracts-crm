package com.Gradjevinsko_preduzece.service_imp;

import com.Gradjevinsko_preduzece.entity.ConstructionCompany;
import com.Gradjevinsko_preduzece.exception.BadRequestException;
import com.Gradjevinsko_preduzece.exception.NotFoundException;
import com.Gradjevinsko_preduzece.mapper.ConstructionCompanyMapper;
import com.Gradjevinsko_preduzece.record.ConstructionCompanyRecord;
import com.Gradjevinsko_preduzece.repository.ConstructionCompanyRepository;
import com.Gradjevinsko_preduzece.service.IConstructionCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructionCompanyService implements IConstructionCompanyService {

    private final ConstructionCompanyMapper constructionCompanyMapper;
    private final ConstructionCompanyRepository constructionCompanyRepository;

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

    @Override
    public ConstructionCompanyRecord getCompanyById(Long id) {
        if (id == null){
            throw new BadRequestException("ConstructionCompanyService getCompanyById() :: ID is empty");
        }
        ConstructionCompany company = constructionCompanyRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("ContractService findContractById() :: Contract not found")
        );
        return constructionCompanyMapper.companyToCompanyRecord(company);

    }
}
