package com.casestudy.repository.customer;

import com.casestudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
