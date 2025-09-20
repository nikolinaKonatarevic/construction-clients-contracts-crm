package com.Gradjevinsko_preduzece.service_imp;

import com.Gradjevinsko_preduzece.entity.Customer;
import com.Gradjevinsko_preduzece.exception.BadRequestException;
import com.Gradjevinsko_preduzece.exception.NotFoundException;
import com.Gradjevinsko_preduzece.exception.ValidationException;
import com.Gradjevinsko_preduzece.mapper.CustomerMapper;
import com.Gradjevinsko_preduzece.record.CreateCustomerRecord;
import com.Gradjevinsko_preduzece.record.CustomerRecord;
import com.Gradjevinsko_preduzece.record.UpdateCustomerRecord;
import com.Gradjevinsko_preduzece.repository.CustomerRepository;
import com.Gradjevinsko_preduzece.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService (CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerMapper = customerMapper;
        this.customerRepository= customerRepository;
    }

    @Override
    public List<CustomerRecord> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::customerToCustomerRecord).toList();

    }

    @Override
    public CustomerRecord getCustomerById(Long id) {
        if(id == null){
            throw new BadRequestException("CustomerService findById() :: Customer id cannot be null");
        }
        Customer customer = customerRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("CustomerService findById() :: Customer not found with id "+ id));
        return customerMapper.customerToCustomerRecord(customer);
    }

    @Override
    public CustomerRecord createCustomer(CreateCustomerRecord createCustomerRecord) {
        if (createCustomerRecord == null) {
            throw new BadRequestException("createCustomerRecord createCustomer() :: Customer cannot be null");
        } else if (createCustomerRecord.firstname()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer firstname cannot be null");
        } else if (createCustomerRecord.lastname()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer lastname cannot be null");
        } else if (createCustomerRecord.JMBG()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer JMBG cannot be null");
        } else if (createCustomerRecord.idCardNum()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer idCardNum cannot be null");
        } else if (createCustomerRecord.email()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer email cannot be null");
        } else if (createCustomerRecord.phoneNumber()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer phoneNumber cannot be null");
        } else if (createCustomerRecord.address()==null) {
            throw new ValidationException("createCustomerRecord createCustomer() :: Customer address cannot be null");
        }

        Customer customer = customerMapper.createCustomerRecordToCustomer(createCustomerRecord);
        return customerMapper.customerToCustomerRecord(customerRepository.save(customer));

    }

    @Override
    public CustomerRecord updateCustomer(UpdateCustomerRecord updateCustomerRecord) {
        if (updateCustomerRecord == null) {
            throw new BadRequestException("createCustomerRecord updateCustomer() :: Customer cannot be null");
        }
        Customer customer = customerRepository.findById(updateCustomerRecord.id()).orElseThrow(
                () -> new NotFoundException(" createCustomerRecord updateCustomer() :: Customer cannot be found")
        );

        customerMapper.updateCustomerFromRecord(updateCustomerRecord, customer);
        return customerMapper.customerToCustomerRecord(customerRepository.save(customer));
    }
}
