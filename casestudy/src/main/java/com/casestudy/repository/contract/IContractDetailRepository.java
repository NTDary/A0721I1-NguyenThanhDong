package com.casestudy.repository.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    @Query(value="SELECT * FROM contract_detail c WHERE c.contract_detail_id like concat('%',?1,'%') ",
            countQuery="SELECT count(*) FROM contract_detail c WHERE c.contract_detail_id like concat('%',?1,'%') ",
            nativeQuery=true)
    Page<ContractDetail> searchById(String id, Pageable pageable);
}
