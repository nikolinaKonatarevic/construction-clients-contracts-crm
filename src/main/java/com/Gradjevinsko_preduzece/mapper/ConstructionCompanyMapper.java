package com.Gradjevinsko_preduzece.mapper;

import com.Gradjevinsko_preduzece.entity.ConstructionCompany;
import com.Gradjevinsko_preduzece.record.ConstructionCompanyRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConstructionCompanyMapper {
    ConstructionCompanyRecord companyToCompanyRecord (ConstructionCompany company);

}
