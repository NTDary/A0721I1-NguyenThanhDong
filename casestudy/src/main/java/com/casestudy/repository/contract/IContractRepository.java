package com.casestudy.repository.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query(value="SELECT * FROM contract c WHERE c.contract_id like concat('%',?1,'%') ",
            countQuery="SELECT count(*) FROM contract c WHERE c.contract_id like concat('%',?1,'%') ",
            nativeQuery=true)
    Page<Contract> searchById(String id, Pageable pageable);

}
