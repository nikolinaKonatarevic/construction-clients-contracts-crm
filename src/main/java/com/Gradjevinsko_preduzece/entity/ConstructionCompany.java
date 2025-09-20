package com.Gradjevinsko_preduzece.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "construction_company")
@Data
public class ConstructionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="PIB")
    private String PIB;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="representative")
    private String representative;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contract;
}
