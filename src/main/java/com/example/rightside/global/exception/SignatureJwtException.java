package com.example.rightside.global.exception;

import com.example.rightside.global.error.CustomException;
import com.example.rightside.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final SignatureJwtException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}