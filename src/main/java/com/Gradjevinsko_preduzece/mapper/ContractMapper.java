package com.Gradjevinsko_preduzece.mapper;
import com.Gradjevinsko_preduzece.entity.Contract;
import com.Gradjevinsko_preduzece.record.ContractRecord;
import com.Gradjevinsko_preduzece.record.CreateContractRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    Contract createContractRecordToContract (CreateContractRecord contractRecord);

    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "customerId", source = "customer.id")
    ContractRecord contractToContractRecord (Contract contract);
}
