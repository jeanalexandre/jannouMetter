package com.jannouMetter.bo;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email")
    private String email;

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
}
