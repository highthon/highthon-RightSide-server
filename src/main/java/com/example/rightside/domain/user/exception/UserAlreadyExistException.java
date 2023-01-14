package com.example.rightside.domain.user.exception;

import com.example.rightside.global.error.CustomException;
import com.example.rightside.global.error.ErrorCode;

public class UserAlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserAlreadyExistException();

    private UserAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXIST);
    }
}