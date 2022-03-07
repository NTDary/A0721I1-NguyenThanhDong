package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
    Page<Province> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM province WHERE name like concat('%', ?1 ,'%')",
            nativeQuery=true)
    Page<Province> searchByName(String name, Pageable pageable);

//    @Query(value = "SELECT * FROM customer c INNER JOIN province p on c.province_id = p.id where p.id = ?1",
//            nativeQuery = true)
@Query(value = "SELECT * FROM customer WHERE province_id = ?1",
        nativeQuery=true)
    Page<Customer> searchByProvince(Long province_id);
}
