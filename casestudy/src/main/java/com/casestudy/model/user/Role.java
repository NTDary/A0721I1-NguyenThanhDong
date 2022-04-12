package com.casestudy.model.user;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long role_id;
    @Column(name = "role_name", nullable = false)
    private String role_name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;

    public Role(String name) {
        this.role_name = name;
    }

    public Role(Long role_id, String role_name, Set<User> users) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.users = users;
    }



    public Role() {
    }

    public Role(Long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
