package com.casestudy.service.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService extends IGeneralService<ContractDetail> {
    Page<ContractDetail> searchById(String id, Pageable pageable);
}
