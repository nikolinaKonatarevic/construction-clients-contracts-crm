package com.Gradjevinsko_preduzece.service;

import com.Gradjevinsko_preduzece.record.CreateCustomerRecord;
import com.Gradjevinsko_preduzece.record.CustomerRecord;
import com.Gradjevinsko_preduzece.record.UpdateCustomerRecord;

import java.util.List;

public interface ICustomerService {

    public List<CustomerRecord> getAllCustomers();
    public CustomerRecord getCustomerById(Long id);
    public CustomerRecord createCustomer (CreateCustomerRecord customer);
    public CustomerRecord updateCustomer (UpdateCustomerRecord customer);

}
