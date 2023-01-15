package com.example.rightside.domain.user.exception;

import com.example.rightside.global.error.CustomException;
import com.example.rightside.global.error.ErrorCode;

public class InvalidUserException extends CustomException {
    public static final CustomException EXCEPTION =
            new InvalidUserException();

    private InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
