package com.enigma.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_credential")
public class UserCredential {
    @Id
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "password", nullable = false, length = 225)
    private String password;

    public UserCredential() {
    }

    public UserCredential(String email) {
        this.email = email;
    }

    public UserCredential(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "UserCredential{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
