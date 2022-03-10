package com.codegym.register.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @NotBlank()
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank()
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank()
    @Pattern(regexp = "(((\\+|)|84)|0)(3|5|7|8|9)+([0-9]{8})\\b", message = "vui lòng nhập đúng định dạng sdt (+84 or 03, 05, 07, 08, 09) độ dài 10 số")
    private String phone;

    @NotNull
    @Min(value = 18)
    private Long age;

    @NotBlank
    @Email
    private String email;
//
    public User() {
    }
    public User(Long id, String firstName, String lastName, String phone, Long age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }
//
//    public User(Long id, @NotBlank(message = "Vui Long Nhap") @Size(min = 5, max = 45) String firstName, String lastName, String phone, int age, String email) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.age = age;
//        this.email = email;
//    }
//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
//
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
//
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
//
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
//
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
