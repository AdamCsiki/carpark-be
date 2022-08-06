package com.endava.pocu.carpark.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(length = 14)
    private String cnp;

    @OneToMany
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;

    @OneToMany
    @JoinTable(
            name = "user_spot",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "spot_id")
    )
    private List<Spot> spots;

    public User() {
    }

    public User(String firstName, String lastName, Integer age, String cnp, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cnp = cnp;
        this.addresses = addresses;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        if(cnp == null) {
            throw new RuntimeException("User's cnp should not be null.");
        } else if(cnp.isBlank()) {
            throw new RuntimeException("User`s cnp should not be empty.");
        } else {
            this.cnp = cnp;
        }
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
