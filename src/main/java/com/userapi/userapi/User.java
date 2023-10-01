package com.userapi.userapi;
import javax.validation.constraints.*;
import javax.persistence.*;
import io.quarkus.runtime.annotations.*;

@RegisterForReflection
@Entity
@Table(name="USERDATA")
public class User implements Comparable<User> {

    @Override
    public int compareTo(User o) {
        return this.id - o.id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTHDAY", nullable = false, length = 10)
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Birthday format: yyyy-MM-dd.")
    private String birthday;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    //Empty constructor for JSON deserialization
    public User() {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
