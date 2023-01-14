package com.example.rightside.domain.user.exception;

import com.example.rightside.global.error.CustomException;
import com.example.rightside.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}