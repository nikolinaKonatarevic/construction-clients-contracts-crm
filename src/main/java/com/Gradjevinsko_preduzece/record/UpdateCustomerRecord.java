package com.Gradjevinsko_preduzece.record;

public record UpdateCustomerRecord(Long id, String firstname, String lastname, String JMBG,
                                   String idCardNum, String email, String phoneNumber, String address) {
}
