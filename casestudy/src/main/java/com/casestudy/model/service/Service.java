package com.casestudy.model.service;

import com.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;

    @NotNull
    private String service_name;

    private Long service_area;

    @NotNull
    private Double service_cost;

    private Long service_max_people;

    private String standard_room;

    private String description_other_convenience;

    private Double pool_area;

    private Long number_of_floors;

    @OneToMany(mappedBy = "contract_id")
    private Set<Contract> contracts;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    public Service() {
    }

    public Service(Long service_id, @NotNull String service_name, Long service_area, @NotNull Double service_cost, Long service_max_people, String standard_room, String description_other_convenience, Double pool_area, Long number_of_floors) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public Service(Long service_id, @NotNull String service_name, Long service_area, @NotNull Double service_cost, Long service_max_people, String standard_room, String description_other_convenience, Double pool_area, Long number_of_floors, Set<Contract> contracts, RentType rentType, ServiceType serviceType) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.contracts = contracts;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Long getService_area() {
        return service_area;
    }

    public void setService_area(Long service_area) {
        this.service_area = service_area;
    }

    public Double getService_cost() {
        return service_cost;
    }

    public void setService_cost(Double service_cost) {
        this.service_cost = service_cost;
    }

    public Long getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(Long service_max_people) {
        this.service_max_people = service_max_people;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public Double getPool_area() {
        return pool_area;
    }

    public void setPool_area(Double pool_area) {
        this.pool_area = pool_area;
    }

    public Long getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(Long number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
