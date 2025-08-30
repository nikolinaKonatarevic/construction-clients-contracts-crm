package com.Gradjevinsko_preduzece.record;

import com.Gradjevinsko_preduzece.entity.StatusEnum;

import java.time.LocalDate;

public record CreateContractRecord(LocalDate date, String subject, String conclusion,
                                   StatusEnum status, String address, Long customerId, Long companyId) {
}
