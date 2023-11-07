package com.example.spring_practical.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    private String id;
    private String userName;
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "invalid email")

    private String email;
    private String password;

    private String status;

}
