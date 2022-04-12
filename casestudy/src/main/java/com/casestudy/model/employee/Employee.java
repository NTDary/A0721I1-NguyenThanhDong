package com.casestudy.model.employee;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    @NotNull
    private String employee_name;
    @NotNull
    private Date employee_birthday;
    @NotNull
    private String employee_id_card;
    @NotNull
    private Double employee_salary;
    @NotNull
    private String employee_phone;
    private String employee_email;
    private String employee_adress;

    @OneToMany(mappedBy = "contract_id")
    private Set<Contract> contracts;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name= "division_id", nullable = false)
    private Division division;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name= "position_id", nullable = false)
    private Position position;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name= "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name= "username")
    private User user;






    public Employee() {
    }

    public Employee(Long employee_id, String employee_name, Date employee_birthday, String employee_id_card, Double employee_salary, String employee_phone, String employee_email, String employee_adress) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_adress = employee_adress;
    }



    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Date getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(Date employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_adress() {
        return employee_adress;
    }

    public void setEmployee_adress(String employee_adress) {
        this.employee_adress = employee_adress;
    }
}
