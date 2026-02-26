package org.example.springpractice.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.springpractice.common.exception.BaseException;
import org.example.springpractice.common.model.BaseResponseStatus;
import org.example.springpractice.user.model.User;
import org.example.springpractice.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserDto.SignupReq dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            //TODO: 중복 이메일 가입 처리
            throw BaseException.from(BaseResponseStatus.DUPLICATED_EMAIL);
        }
        userRepository.save(dto.toEntity());
    }

    public UserDto.LoginRes login(UserDto.LoginReq dto) {
        User entity = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(
                //TODO: 유효하지 않은 입력값(이메일 or 패스워드)
                () -> BaseException.from(BaseResponseStatus.INVALID_INPUT)
        );
        return UserDto.LoginRes.fromEntity(entity);
    }
}
