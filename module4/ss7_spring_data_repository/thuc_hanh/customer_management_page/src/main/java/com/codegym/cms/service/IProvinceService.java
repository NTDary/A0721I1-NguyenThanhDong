package com.codegym.cms.service;


import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProvinceService extends IGeneralService<Province> {
    Page<Province> findAll(Pageable pageable);
    Page<Province> searchByName(String name, Pageable pageable);

}
