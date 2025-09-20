package com.Gradjevinsko_preduzece.service_imp;

import com.Gradjevinsko_preduzece.entity.ConstructionCompany;
import com.Gradjevinsko_preduzece.entity.Contract;
import com.Gradjevinsko_preduzece.entity.ContractClause;
import com.Gradjevinsko_preduzece.entity.Customer;
import com.Gradjevinsko_preduzece.exception.BadRequestException;
import com.Gradjevinsko_preduzece.exception.NotFoundException;
import com.Gradjevinsko_preduzece.exception.ValidationException;
import com.Gradjevinsko_preduzece.mapper.ContractClauseMapper;
import com.Gradjevinsko_preduzece.mapper.ContractMapper;
import com.Gradjevinsko_preduzece.record.*;
import com.Gradjevinsko_preduzece.repository.ConstructionCompanyRepository;
import com.Gradjevinsko_preduzece.repository.ContractClauseRepository;
import com.Gradjevinsko_preduzece.repository.ContractRepository;
import com.Gradjevinsko_preduzece.repository.CustomerRepository;
import com.Gradjevinsko_preduzece.service.IContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    private final ContractMapper contractMapper;
    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final ConstructionCompanyRepository companyRepository;
    private final ContractClauseMapper clauseMapper;
    private final ContractClauseRepository clauseRepository;

    public ContractService(ContractMapper contractMapper,
                           ContractRepository contractRepository,
                           CustomerRepository customerRepository, ConstructionCompanyRepository companyRepository,
                           ContractClauseMapper clauseMapper, ContractClauseRepository clauseRepository) {
        this.contractMapper = contractMapper;
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
        this.companyRepository = companyRepository;
        this.clauseMapper = clauseMapper;
        this.clauseRepository = clauseRepository;
    }

    @Override
    public List<ContractRecord> findAllContracts() {
        List<Contract> contracts = contractRepository.findAll();
        return contracts.stream().map(contractMapper::contractToContractRecord).toList();
    }

    @Override
    public ContractRecord findContractById(Long id) {
        if(id == null){
            throw new BadRequestException("ContractService findContractById() :: Contract id cannot be null");
        }
        Contract contract = contractRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("ContractService findContractById() :: Contract not found")
        );
        return contractMapper.contractToContractRecord(contract);
    }

    @Override
    public ContractRecord createContract(CreateContractRecord createContractRecord) {
        if (createContractRecord == null) {
            throw new BadRequestException("ContractService createContract() :: Contract cannot be null");
        }
        // here maybe to as IF NULL - can be an issue
        Customer customer = customerRepository.findById(createContractRecord.customerId()).orElseThrow(
                ()-> new NotFoundException("ContractService createContract() :: Customer not found")
        );
        ConstructionCompany company = companyRepository.findById(createContractRecord.companyId()).orElseThrow(
                () -> new NotFoundException("ContractService createContract() :: Company not found")
        );

        if (createContractRecord.date()==null) {
            throw new ValidationException("ContractService createContract() :: Date cannot be null");
        } else if (createContractRecord.subject()==null) {
            throw new ValidationException("ContractService createContract() :: subject cannot be null");
        } else if (createContractRecord.conclusion()==null) {
            throw new ValidationException("ContractService createContract() :: conclusion cannot be null");
        } else if (createContractRecord.status()==null) {
            throw new ValidationException("ContractService createContract() :: status cannot be null");
        } else if (createContractRecord.address()==null) {
            throw new ValidationException("ContractService createContract() :: subject cannot be null");
        } else if (createContractRecord.createContractClauseRecords().isEmpty()) {
            throw new ValidationException("ContractService createContract() :: Clauses cannot be empty");
        }

        Contract contract = contractMapper.createContractRecordToContract(createContractRecord);
        contract.setCompany(company);
        contract.setCustomer(customer);

        for (CreateContractClauseRecord record : createContractRecord.createContractClauseRecords()) {
            ContractClause clause = clauseMapper.createContractClauseRecordToContractClause(record);
            clause.setContract(contract); // set back-reference
            contract.addContractClauses(clause); // add to contract
        }

        return contractMapper.contractToContractRecord(contractRepository.save(contract));
    }


    @Override
    public ContractRecord updateContract(UpdateContractRecord updateContractRecord) {
        if (updateContractRecord == null) {
            throw new BadRequestException("ContractService updateContract() :: Contract cannot be null");
        }

        Contract contract = contractRepository.findById(updateContractRecord.id()).orElseThrow(
                ()-> new NotFoundException("ContractService  updateContract() :: Contract not found with the id "
                        + updateContractRecord.id())
        );

        // here maybe to as IF NULL - can be an issue
        Customer customer = customerRepository.findById(updateContractRecord.customerId()).orElseThrow(
                ()-> new NotFoundException("ContractService createContract() :: Customer not found")
        );
        ConstructionCompany company = companyRepository.findById(updateContractRecord.companyId()).orElseThrow(
                () -> new NotFoundException("ContractService createContract() :: Company not found")
        );


        if (updateContractRecord.date()==null) {
            throw new ValidationException("ContractService updateContract() :: Date cannot be null");
        } else if (updateContractRecord.subject()==null) {
            throw new ValidationException("ContractService updateContract() :: subject cannot be null");
        } else if (updateContractRecord.conclusion()==null) {
            throw new ValidationException("ContractService updateContract() :: conclusion cannot be null");
        } else if (updateContractRecord.status()==null) {
            throw new ValidationException("ContractService updateContract() :: status cannot be null");
        } else if (updateContractRecord.address()==null) {
            throw new ValidationException("ContractService updateContract() :: subject cannot be null");
        } else if (updateContractRecord.updateContractClauseRecords() == null ||
                updateContractRecord.updateContractClauseRecords().isEmpty()) {
            throw new ValidationException("ContractService updateContract() :: Clauses cannot be empty");
        }

        contractMapper.updateContractFromRecord(updateContractRecord, contract);
        contract.setCompany(company);
        contract.setCustomer(customer);
        contract.getContractClauses().clear();

        for (UpdateContractClauseRecord record : updateContractRecord.updateContractClauseRecords()) {
            ContractClause clause = clauseMapper.updateClauseFromRecord(record);
            clause.setContract(contract); // set back-reference
            contract.addContractClauses(clause); // add to contract
        }

        //contractMapper.updateContractFromRecord(updateContractRecord,contract);
        System.out.println("ovo je novi contract" + contract);
        return contractMapper.contractToContractRecord(contractRepository.save(contract));
    }

}
