package com.Gradjevinsko_preduzece.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract")
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private LocalDate date;

    @Column(name="subject")
    private String subject;

    @Column(name="conclusion")
    private String conclusion;

    @Column(name="status")
    private StatusEnum status;

    @Column(name="address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "constrction_company_id")
    private ConstructionCompany company;

    @OneToMany(mappedBy = "contract")
    private List<ContractClause> contractClauses;
}
