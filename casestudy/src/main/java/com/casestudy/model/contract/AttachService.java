package com.casestudy.model.contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attach_service_id;
    @NotNull
    private String attach_service_name;
    @NotNull
    private Double attach_service_cost;
    private String attach_service_unit;

    private String attach_service_status;

    @OneToMany(mappedBy = "contract_detail_id")
    Set<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(Long attach_service_id, String attach_service_name, Double attach_service_cost, String attach_service_unit, String attach_service_status) {
        this.attach_service_id = attach_service_id;
        this.attach_service_name = attach_service_name;
        this.attach_service_cost = attach_service_cost;
        this.attach_service_unit = attach_service_unit;
        this.attach_service_status = attach_service_status;
    }

    public AttachService(Long attach_service_id, @NotNull String attach_service_name, @NotNull Double attach_service_cost, String attach_service_unit, String attach_service_status, Set<ContractDetail> contractDetails) {
        this.attach_service_id = attach_service_id;
        this.attach_service_name = attach_service_name;
        this.attach_service_cost = attach_service_cost;
        this.attach_service_unit = attach_service_unit;
        this.attach_service_status = attach_service_status;
        this.contractDetails = contractDetails;
    }



    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Long getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(Long attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public Double getAttach_service_cost() {
        return attach_service_cost;
    }

    public void setAttach_service_cost(Double attach_service_cost) {
        this.attach_service_cost = attach_service_cost;
    }

    public String getAttach_service_unit() {
        return attach_service_unit;
    }

    public void setAttach_service_unit(String attach_service_unit) {
        this.attach_service_unit = attach_service_unit;
    }

    public String getAttach_service_status() {
        return attach_service_status;
    }

    public void setAttach_service_status(String attach_service_status) {
        this.attach_service_status = attach_service_status;
    }
}
