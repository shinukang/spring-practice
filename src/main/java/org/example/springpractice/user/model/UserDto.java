package org.example.springpractice.user.model;

import lombok.Getter;

public class UserDto {

    @Getter
    public static class SignupReq {
        private String name;
        private String email;
        private String password;

        public User toEntity() {
            return User.builder()
                    .name(this.name)
                    .email(this.email)
                    .password(this.password)
                    .build();
        }
    }
}
