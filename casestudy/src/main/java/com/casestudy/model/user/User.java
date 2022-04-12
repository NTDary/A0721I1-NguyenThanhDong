package com.casestudy.model.user;

import com.casestudy.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User(String username, String password, Set<Employee> employees, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.employees = employees;
        this.roles = roles;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
