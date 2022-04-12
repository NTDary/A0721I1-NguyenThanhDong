package com.casestudy.service.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract> {
    Page<Contract> searchById(String id, Pageable pageable);
}
