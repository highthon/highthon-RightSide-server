package com.example.rightside.domain.post.exception;

import com.example.rightside.global.error.CustomException;
import com.example.rightside.global.error.ErrorCode;

public class PostNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
