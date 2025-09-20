package com.Gradjevinsko_preduzece.mapper;

import com.Gradjevinsko_preduzece.entity.Customer;
import com.Gradjevinsko_preduzece.record.CreateCustomerRecord;
import com.Gradjevinsko_preduzece.record.CustomerRecord;
import com.Gradjevinsko_preduzece.record.UpdateCustomerRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer createCustomerRecordToCustomer (CreateCustomerRecord customerRecord);
    CustomerRecord customerToCustomerRecord (Customer customer);
    void updateCustomerFromRecord(UpdateCustomerRecord record, @MappingTarget Customer customer);

}
