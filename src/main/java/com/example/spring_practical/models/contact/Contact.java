package com.example.spring_practical.models.contact;

import com.example.spring_practical.models.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mobile;
    private String address;

//    @Column(name = "user_id",insertable = false , updatable = false)
//    private String userId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "userId" )
//    private User user;


}
