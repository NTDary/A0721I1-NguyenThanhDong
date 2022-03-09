package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer>{
    Page<Customer> findAll(Pageable pageable);
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> searchByName(String firstName, Pageable pageable);
    Page<Customer> searchByProvince(Long province_id, Pageable pageable);
}
