package com.casestudy.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_type_id;
    private String service_type_name;

    @OneToMany(mappedBy = "service_id")
    private Set<Service> services;

    public ServiceType() {
    }

    public ServiceType(Long service_type_id, String service_type_name) {
        this.service_type_id = service_type_id;
        this.service_type_name = service_type_name;
    }

    public Long getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(Long service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
