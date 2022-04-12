package com.casestudy.repository.employee;

import com.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division, Long> {
}
