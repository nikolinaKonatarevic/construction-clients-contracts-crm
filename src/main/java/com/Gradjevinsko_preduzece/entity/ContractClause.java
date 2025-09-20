package com.Gradjevinsko_preduzece.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contract_clause")
@Data
public class ContractClause {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;


}
