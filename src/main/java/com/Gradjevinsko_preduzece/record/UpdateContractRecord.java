package com.Gradjevinsko_preduzece.record;

import com.Gradjevinsko_preduzece.entity.StatusEnum;

import java.time.LocalDate;
import java.util.List;

public record UpdateContractRecord(Long id, LocalDate date, String subject, String conclusion,
                                   StatusEnum status, String address, Long customerId, Long companyId,
                                   List<UpdateContractClauseRecord> updateContractClauseRecords) {
}
