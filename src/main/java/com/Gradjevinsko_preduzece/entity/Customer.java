package com.Gradjevinsko_preduzece.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name= "lastname")
    private String lastname;

    @Column(name= "JMBG")
    private String JMBG;

    @Column(name= "id_card_number")
    private String idCardNum;

    @Column(name= "email")
    private String email;

    @Column(name= "phone_number")
    private String phoneNumber;

    @Column(name= "address")
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;


}
