package com.example.rightside.domain.post.presentation.dto.response;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.type.Tag;
import com.example.rightside.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {

    private final Long postId;
    private final String title;
    private final UserResponse user;
    private final Tag tag;
    private final Integer joinCount;
    private final String link;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .tag(post.getTag())
                .user(UserResponse.of(post.getUser()))
                .joinCount(post.getJoinList().size())
                .link(post.getLink())
                .build();
    }
}