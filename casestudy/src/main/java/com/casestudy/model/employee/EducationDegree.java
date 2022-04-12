package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long education_degree_id;
    private String education_degree_name;

    @OneToMany(mappedBy = "employee_id")
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(Long education_degree, String education_degree_name) {
        this.education_degree_id = education_degree;
        this.education_degree_name = education_degree_name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Long getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(Long education_degree) {
        this.education_degree_id = education_degree;
    }

    public String getEducation_degree_name() {
        return education_degree_name;
    }

    public void setEducation_degree_name(String education_degree_name) {
        this.education_degree_name = education_degree_name;
    }
}
