package org.example.springpractice.user.model;

import lombok.Builder;
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

    @Getter
    public static class LoginReq {
        private String email;
        private String password;
    }

    @Getter
    @Builder
    public static class LoginRes {
        private Long id;
        private String name;

        public static LoginRes fromEntity(User entity) {
            return LoginRes.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
        }
    }
}
