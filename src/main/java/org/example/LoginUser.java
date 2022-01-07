package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

    public class LoginUser {
        private String email;
        private String password;

//    public LoginUser(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//    public LoginUser(){
//    }
//
//        public String getEmail() {
//           return email;
//        }
//
//        public String getPassword() {
//         return password;
//         }
    }


