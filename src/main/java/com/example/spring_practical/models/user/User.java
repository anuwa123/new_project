package com.example.spring_practical.models.user;

import com.example.spring_practical.models.contact.Contact;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class User {

    public enum Status{
        ACTIVE,INACTIVE
    }
    @Id
    private String id;
    private String userName;
    @Email(message = "invalid email")
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private Contact contact;



}
