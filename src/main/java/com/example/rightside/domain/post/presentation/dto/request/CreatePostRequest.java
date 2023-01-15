package com.example.rightside.domain.post.presentation.dto.request;

import com.example.rightside.domain.post.domain.type.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreatePostRequest {

    @NotNull(message = "title은 null일 수 없습니다")
    @Size(min = 1, max = 30, message = "제목은 최소 1자 ~ 최대 30자 내외입니다.")
    private String title;

    @NotNull(message = "content는 null일 수 없습니다")
    @Size(min = 1, max = 1000, message = "내용은 최소 1자 ~ 최대 1000자 내외입니다.")
    private String content;

    @NotNull(message = "tag는 null일 수 없습니다")
    private Tag tag;

    private String link;
}
