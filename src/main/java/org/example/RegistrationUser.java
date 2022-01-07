package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationUser {
    private Integer id;
    private String token;
    private String error;

//    public RegistrationUser(Integer id, String token) {
//        this.id = id;
//        this.token = token;
//    }
//    public RegistrationUser(){
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getToken() {
//        return token;
//    }
}
