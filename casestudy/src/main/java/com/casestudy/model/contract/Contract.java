package com.casestudy.model.contract;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contract_id;
    @NotNull
    private Date contract_start_date;
    @NotNull
    private Date contract_end_date;
    @NotNull
    private Double contract_deposit;
    @NotNull
    private Double contract_total_money;

    @OneToMany(mappedBy = "contract_detail_id")
    Set<ContractDetail> contractDetails;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id",nullable = false)
    private Service service;

    public Contract() {
    }

    public Contract(Long contract_id, Date contract_start_date, Date contract_end_date, Double contract_deposit, Double contract_total_money, Set<ContractDetail> contractDetails) {
        this.contract_id = contract_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.contractDetails = contractDetails;
    }

    public Contract(Long contract_id, @NotNull Date contract_start_date, @NotNull Date contract_end_date, @NotNull Double contract_deposit, @NotNull Double contract_total_money, Set<ContractDetail> contractDetails, Employee employee, Customer customer, Service service) {
        this.contract_id = contract_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }


    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getContract_id() {
        return contract_id;
    }

    public void setContract_id(Long contract_id) {
        this.contract_id = contract_id;
    }

    public Date getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(Date contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public Date getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(Date contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public Double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(Double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public Double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(Double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }
}
