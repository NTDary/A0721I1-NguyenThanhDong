package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long division_id;
    private String division_name;

    @OneToMany(mappedBy = "employee_id")
    private Set<Employee> employees;

    public Division() {
    }

    public Division(long division_id, String division_name) {
        this.division_id = division_id;
        this.division_name = division_name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Long getDivision_id() {
        return division_id;
    }

    public void setDivision_id(Long devision_id) {
        this.division_id = devision_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String devision_name) {
        this.division_name = devision_name;
    }
}
