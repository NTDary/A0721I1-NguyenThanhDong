package com.casestudy.service.service;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Service;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceS extends IGeneralService<Service> {
    Page<Service> searchByName(String nameService, Pageable pageable);
}
