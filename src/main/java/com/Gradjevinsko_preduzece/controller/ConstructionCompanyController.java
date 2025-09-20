package com.Gradjevinsko_preduzece.controller;


import com.Gradjevinsko_preduzece.record.ConstructionCompanyRecord;
import com.Gradjevinsko_preduzece.record.CustomerRecord;
import com.Gradjevinsko_preduzece.service_imp.ConstructionCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/company")

public class ConstructionCompanyController {

    private final ConstructionCompanyService constructionCompanyService;

    public ConstructionCompanyController(ConstructionCompanyService constructionCompanyService) {
        this.constructionCompanyService = constructionCompanyService;
    }

    @GetMapping("")
    public ResponseEntity<List<ConstructionCompanyRecord>> findAll(){
        return new ResponseEntity<>(constructionCompanyService.getAllConstructionCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConstructionCompanyRecord> findById(@PathVariable Long id) {
        return new ResponseEntity<>(constructionCompanyService.getCompanyById(id), HttpStatus.OK);
    }
}
