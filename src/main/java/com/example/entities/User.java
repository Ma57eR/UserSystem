package com.example.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 4, max = 30)
    @Column(nullable = false)
    private String username;

    @Size(min = 6, max = 50)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastLogin;

    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fiend_id")
    @ManyToMany(targetEntity = User.class, mappedBy = "username")
    private Set<User> friends;

    @Transient
    private String fullName;



    public User() {
    }

    public User(String username, String password, String email, int age, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.isDeleted = false;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredOn = LocalDateTime.now();
        this.friends = new HashSet<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
