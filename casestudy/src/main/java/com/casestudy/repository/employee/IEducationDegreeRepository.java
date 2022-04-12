package com.casestudy.repository.employee;

import com.casestudy.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Long> {
}
