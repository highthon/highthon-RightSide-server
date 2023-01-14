package com.example.rightside.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSigninRequest {

    @NotBlank(message = "account_id는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String accountId;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    private String password;
}