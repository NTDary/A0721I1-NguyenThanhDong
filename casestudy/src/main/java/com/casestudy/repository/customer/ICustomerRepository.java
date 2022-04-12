package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value="SELECT * FROM customer c WHERE c.customer_name like concat('%',?1,'%') ",
            countQuery="SELECT count(*) FROM customer c WHERE c.customer_name like concat('%',?1,'%') ",
            nativeQuery=true)
    Page<Customer> searchByName(String nameCustomer, Pageable pageable);

//    @Query(value="select c.customer_id, c.customer_name, ct.customer_type_name, hd.contract_id, sv.service_name, att.attach_service_name  from customer as c\n" +
//            "inner join customer_type as ct on ct.customer_type_id = c.customer_type_id\n" +
//            "inner join contract as hd on hd.customer_id = c.customer_id\n" +
//            "inner join service as sv on sv.service_id = hd.service_id\n" +
//            "left join contract_detail as hdct on hdct.contract_id = hd.contract_id\n" +
//            "left join attach_service as att on att.attach_service_id = hdct.attach_service_id",
////            countQuery="SELECT count(*) from customer as c\n" +
////                    "inner join customer_type as ct on ct.customer_type_id = c.customer_type_id\n" +
////                    "inner join contract as hd on hd.customer_id = c.customer_id\n" +
////                    "inner join service as sv on sv.service_id = hd.service_id\n" +
////                    "left join contract_detail as hdct on hdct.contract_id = hd.contract_id\n" +
////                    "left join attach_service as att on att.attach_service_id = hdct.attach_service_id\n" +
////                    "where c.customer_name like concat('%',?1,'%') or sv.service_name like concat('%',?1,'%')",
//            nativeQuery=true)
    @Query(value="select * from customer c \n" +
            "inner join customer_type ct on c.customer_type_id = ct.customer_type_id\n" +
            "inner join contract as hd on hd.customer_id = c.customer_id\n" +
            "inner join service as sv on sv.service_id = hd.service_id\n" +
            "left join contract_detail as hdct on hdct.contract_id = hd.contract_id\n" +
            "left join attach_service as att on att.attach_service_id = hdct.attach_service_id\n" +
            "where c.customer_name like concat('%',?1,'%') or sv.service_name like concat('%',?1,'%')",
            countQuery="SELECT count(*) from customer as c\n" +
                    "inner join customer_type as ct on ct.customer_type_id = c.customer_type_id\n" +
                    "inner join contract as hd on hd.customer_id = c.customer_id\n" +
                    "inner join service as sv on sv.service_id = hd.service_id\n" +
                    "left join contract_detail as hdct on hdct.contract_id = hd.contract_id\n" +
                    "left join attach_service as att on att.attach_service_id = hdct.attach_service_id\n" +
                    "where c.customer_name like concat('%',?1,'%') or sv.service_name like concat('%',?1,'%')",
    nativeQuery=true)
    Page<Customer> searchCS(String name, Pageable pageable);
}
