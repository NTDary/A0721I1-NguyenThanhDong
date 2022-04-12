package com.casestudy.repository.service;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Long> {
    @Query(value="SELECT * FROM service s WHERE s.service_name like concat('%',?1,'%') ",
            countQuery="SELECT count(*) FROM service s WHERE s.service_name like concat('%',?1,'%') ",
            nativeQuery=true)
    Page<Service> searchByName(String nameService, Pageable pageable);
}
