package com.example.rightside.domain.user.presentation.dto;

import com.example.rightside.domain.user.presentation.dto.request.UserSigninRequest;
import com.example.rightside.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.rightside.domain.user.presentation.dto.response.TokenResponse;
import com.example.rightside.domain.user.service.UserSigninService;
import com.example.rightside.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserSigninService userSigninService;

    @PostMapping
    public void signUp(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse signIn(@RequestBody @Valid UserSigninRequest request) {
        return userSigninService.execute(request);
    }

}