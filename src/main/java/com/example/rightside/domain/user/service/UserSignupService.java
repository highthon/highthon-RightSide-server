package com.example.rightside.domain.user.service;

import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.domain.repository.UserRepository;
import com.example.rightside.domain.user.exception.UserAlreadyExistException;
import com.example.rightside.domain.user.presentation.dto.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(UserSignupRequest request) {
        checkUserExist(request.getAccountId());

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build());
    }
    private void checkUserExist(String accountId) {
        Optional<User> user = userRepository.findByAccountId(accountId);
        if(user.isPresent())
            throw UserAlreadyExistException.EXCEPTION;
    }
}