package com.casestudy.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rent_type_id;
    private String rent_type_name;
    private Double rent_type_cost;

    @OneToMany(mappedBy = "service_id")
    private Set<Service> services;

    public RentType() {
    }

    public RentType(Long rent_type_id, String rent_type_name, Double rent_type_cost) {
        this.rent_type_id = rent_type_id;
        this.rent_type_name = rent_type_name;
        this.rent_type_cost = rent_type_cost;
    }

    public Long getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(Long rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public Double getRent_type_cost() {
        return rent_type_cost;
    }

    public void setRent_type_cost(Double rent_type_cost) {
        this.rent_type_cost = rent_type_cost;
    }
}
