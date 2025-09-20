package com.Gradjevinsko_preduzece.controller;


import com.Gradjevinsko_preduzece.record.*;
import com.Gradjevinsko_preduzece.service_imp.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contract")

public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("")
    public ResponseEntity<List<ContractRecord>> findAll(){
        return new ResponseEntity<>(contractService.findAllContracts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractRecord> findById(@PathVariable Long id) {
        return new ResponseEntity<>(contractService.findContractById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContractRecord> save(@RequestBody CreateContractRecord createContractRecord) {
        return new ResponseEntity<>(contractService.createContract(createContractRecord), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ContractRecord> update(@RequestBody UpdateContractRecord updateContractRecord) {
        return new ResponseEntity<>(contractService.updateContract(updateContractRecord), HttpStatus.OK);
    }

}
