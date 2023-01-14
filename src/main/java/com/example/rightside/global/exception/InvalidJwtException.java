package com.example.rightside.global.exception;

import com.example.rightside.global.error.CustomException;
import com.example.rightside.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}