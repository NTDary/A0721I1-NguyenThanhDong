package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);
    Iterable<Customer> findAllByProvince (Province province);

    @Query(value="SELECT * FROM customer c WHERE c.firstName like concat('%',?1,'%') ",
            countQuery="SELECT count(*) FROM customer c WHERE c.firstName like concat('%',?1,'%') ",
            nativeQuery=true)
    Page<Customer> searchByName(String firstName, Pageable pageable);

    @Query(value = "SELECT * FROM customer c INNER JOIN province p on c.province_id = p.id where p.id = ?1",
            nativeQuery = true)
    Page<Customer> searchByProvince(Long province_id, Pageable pageable);

}
