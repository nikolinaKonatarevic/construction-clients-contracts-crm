package com.Gradjevinsko_preduzece.mapper;


import com.Gradjevinsko_preduzece.entity.ContractClause;
import com.Gradjevinsko_preduzece.record.ContractClauseRecord;
import com.Gradjevinsko_preduzece.record.CreateContractClauseRecord;
import com.Gradjevinsko_preduzece.record.UpdateContractClauseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContractClauseMapper {

    @Mapping(target = "contract.id", source = "contractId")
    ContractClause createContractClauseRecordToContractClause (CreateContractClauseRecord createContractClauseRecord);

    @Mapping(target = "contractId", source = "contract.id")
    ContractClauseRecord ContractClauseToContractClauseRecord (ContractClause contractClause);

    @Mapping(target = "contract.id", source = "contractId")
    ContractClause  updateClauseFromRecord(UpdateContractClauseRecord updateContractClauseRecord);

}
