package com.Gradjevinsko_preduzece.service;

import com.Gradjevinsko_preduzece.entity.ContractClause;
import com.Gradjevinsko_preduzece.record.CreateContractClauseRecord;
import com.Gradjevinsko_preduzece.record.UpdateContractClauseRecord;

import java.util.List;

public interface IContractClauseService {
    public List<ContractClause> getAllContractClauses();
    public ContractClause createContractClause(CreateContractClauseRecord clause);
    public ContractClause updateContractClause(UpdateContractClauseRecord clause);
}
