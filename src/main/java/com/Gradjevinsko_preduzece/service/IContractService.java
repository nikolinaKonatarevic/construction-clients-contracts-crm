package com.Gradjevinsko_preduzece.service;

import com.Gradjevinsko_preduzece.record.ContractRecord;
import com.Gradjevinsko_preduzece.record.CreateContractRecord;
import com.Gradjevinsko_preduzece.record.UpdateContractRecord;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IContractService {
    public List<ContractRecord> findAllContracts();
    public ContractRecord findContractById(Long id);
    public ContractRecord createContract (CreateContractRecord contract);
    public ContractRecord updateContract (UpdateContractRecord updateContractRecord);
}
