package org.example.springpractice.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.springpractice.common.model.BaseResponse;
import org.example.springpractice.user.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto.SignupReq dto) {
        userService.signup(dto);
        return ResponseEntity.ok("등록 성공");
    }
}
