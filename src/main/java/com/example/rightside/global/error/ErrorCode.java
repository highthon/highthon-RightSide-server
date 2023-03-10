package com.example.rightside.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EXPIRED_JWT(401, "Expired Jwt"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    INVALID_USER(401, "Invalid User"),

    FORBIDDEN(403, "Forbidden"),

    USER_NOT_FOUND(404, "User Not Found"),

    POST_NOT_FOUND(404, "Post Not Found"),

    COMMENT_NOT_FOUND(404, "Comment Not Found"),


    USER_ALREADY_EXIST(409, "User Already Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}