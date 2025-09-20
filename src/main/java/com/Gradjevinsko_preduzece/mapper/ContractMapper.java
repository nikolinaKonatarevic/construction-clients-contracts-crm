package com.Gradjevinsko_preduzece.mapper;
import com.Gradjevinsko_preduzece.entity.Contract;
import com.Gradjevinsko_preduzece.record.ContractRecord;
import com.Gradjevinsko_preduzece.record.CreateContractRecord;
import com.Gradjevinsko_preduzece.record.UpdateContractRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    Contract createContractRecordToContract (CreateContractRecord contractRecord);

    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "contractClauseRecords", source = "contractClauses")
    ContractRecord contractToContractRecord (Contract contract);

    void  updateContractFromRecord(UpdateContractRecord updateContractRecord, @MappingTarget Contract contract);
}
