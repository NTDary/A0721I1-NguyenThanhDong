package com.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long position_id;
    private String position_name;

    @OneToMany(mappedBy = "employee_id")
    private Set<Employee> employees;

    public Position() {
    }

    public Position(Long position_id, String position_name) {
        this.position_id = position_id;
        this.position_name = position_name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }
}
