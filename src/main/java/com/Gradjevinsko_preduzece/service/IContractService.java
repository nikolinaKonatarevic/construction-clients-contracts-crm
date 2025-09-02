package com.Gradjevinsko_preduzece.service;

import com.Gradjevinsko_preduzece.record.ContractRecord;
import com.Gradjevinsko_preduzece.record.CreateContractRecord;
import com.Gradjevinsko_preduzece.record.UpdateCustomerRecord;

import java.util.List;

public interface IContractService {
    public List<ContractRecord> getAllContracts();
    public ContractRecord getContractById (Long id);
    public ContractRecord createContract (CreateContractRecord contract);
    public ContractRecord updateContract (UpdateCustomerRecord contract);
}
