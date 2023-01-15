package com.example.rightside.domain.post.presentation.dto.response;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.type.Tag;
import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostInfoResponse {
    private final String title;
    private final UserResponse user;
    private final Boolean isMine;
    private final Tag tag;
    private final String content;
    private final Integer joinCount;
    private final Boolean isJoined;
    private final String link;

    public static PostInfoResponse of(User user, Post post, boolean isJoined) {
        return PostInfoResponse
                .builder()
                .title(post.getTitle())
                .user(UserResponse.of(post.getUser()))
                .isMine(post.getUser() == user)
                .tag(post.getTag())
                .content(post.getContent())
                .joinCount(post.getJoinList().size())
                .isJoined(isJoined)
                .build();
    }
}