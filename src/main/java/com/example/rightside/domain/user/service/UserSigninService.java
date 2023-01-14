package com.example.rightside.domain.user.service;

import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.exception.PasswordMismatchException;
import com.example.rightside.domain.user.facade.UserFacade;
import com.example.rightside.domain.user.presentation.dto.request.UserSigninRequest;
import com.example.rightside.domain.user.presentation.dto.response.TokenResponse;
import com.example.rightside.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSigninService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse execute(UserSigninRequest request) {
        String accountId = request.getAccountId();
        String password = request.getPassword();

        User user = userFacade.getUserByAccountId(accountId);

        if(!passwordEncoder.matches(password, user.getPassword()))
            throw PasswordMismatchException.EXCEPTION;

        String accessToken = String.valueOf(jwtTokenProvider.generateTokens(accountId));

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}