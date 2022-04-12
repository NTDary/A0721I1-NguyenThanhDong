package com.casestudy.model.customer;

import com.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    @NotNull
    private String customer_name;

    @NotNull
//    @Pattern(regexp = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])[/](0[1-9]|1[0-2])[/](20[0-9]{2})$", message = "vui lòng nhập đúng định dạng")
    private Date customer_birthday;

    @NotNull
    private byte customer_gender;

    @NotNull
    @Pattern(regexp = "^\\d{9}$", message = "vui lòng nhập đúng định dạng XXXXXXXXX (X là số 0-9)")
    private String customer_id_card;

    @NotNull
    @Pattern(regexp = "(\\((84(\\+))\\)|0)(9)(0|1)([0-9]{7})\\b", message = "vui lòng nhập đúng định dạng sdt (84+ or 090, 091) độ dài 10 số")
    private String customer_phone;
    @NotNull
    @Pattern(regexp = "^\\w+(@gmail.)+(com|com.vn)$", message = "vui lòng nhập đúng định dạng Email (xxx@gmail.com OR xxx@gmail.com.vn")
    private String customer_email;
    private String customer_address;

    @OneToMany(mappedBy = "contract_id")
    private Set<Contract> contracts;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(Long customer_id, @NotNull String customer_name, Date customer_birthday, @NotNull byte customer_gender, @NotNull String customer_id_card, @NotNull String customer_phone, String customer_email, String customer_address) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
    }

    public Customer(Long customer_id, @NotNull String customer_name, @NotNull Date customer_birthday, @NotNull byte customer_gender, @NotNull String customer_id_card, @NotNull String customer_phone, String customer_email, String customer_address, Set<Contract> contracts, CustomerType customerType) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.contracts = contracts;
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }



    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Date getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(Date customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public byte getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(byte customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
