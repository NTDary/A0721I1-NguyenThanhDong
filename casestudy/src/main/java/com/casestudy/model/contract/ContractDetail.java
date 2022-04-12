package com.casestudy.model.contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contract_detail_id;

    @NotNull
    private Long quality;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name= "attach_service_id", nullable = false)
    private AttachService attachService;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Long contract_detail_id, @NotNull Long quality) {
        this.contract_detail_id = contract_detail_id;
        this.quality = quality;
    }

    public ContractDetail(Long contract_detail_id, @NotNull Long quality, AttachService attachService, Contract contract) {
        this.contract_detail_id = contract_detail_id;
        this.quality = quality;
        this.attachService = attachService;
        this.contract = contract;
    }



    public Long getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(Long contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Long getQuality() {
        return quality;
    }

    public void setQuality(Long quality) {
        this.quality = quality;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
