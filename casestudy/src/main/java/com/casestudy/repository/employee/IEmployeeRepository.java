package com.casestudy.repository.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);

    @Query(value="SELECT * FROM employee e WHERE e.employee_name like concat('%',?1,'%') ",
            countQuery="SELECT count(*) FROM employee e WHERE e.employee_name like concat('%',?1,'%')",
            nativeQuery=true)
    Page<Employee> searchByName(String nameEmployee, Pageable pageable);

    @Query(value="SELECT * FROM employee e WHERE e.username = ?1 ",
            nativeQuery=true)
    Employee searchNameByUser(String nameEmployee);

}
