package com.endava.pocu.carpark.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = true, length = 20)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @OneToOne(orphanRemoval = true)
    private Address address;

    @OneToMany
    private List<Spot> spots;

    public User() {
    }

    public User(String firstName, String lastName, Integer age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null) {
            throw new RuntimeException("User`s First Name should not be null.");
        } else if(firstName.isBlank()) {
            throw new RuntimeException("User`s First Name should not be blank.");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw new RuntimeException("User`s Last Name should not be null.");
        } else if(lastName.isBlank()) {
            throw new RuntimeException("User`s Last Name should not be blank.");
        } else {
            this.lastName = lastName;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age == null) {
            throw new RuntimeException("User`s age should not be null.");
        } else if(age < 18) {
            throw new RuntimeException("User`s age should be over 18.");
        } else {
            this.age = age;
        }
    }

    public Address getAddresses() {
        return address;
    }

    public void setAddresses(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }
}
