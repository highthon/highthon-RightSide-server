package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.presentation.dto.response.PostListResponse;
import com.example.rightside.domain.post.presentation.dto.response.PostResponse;
import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryJoinedPostsService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public PostListResponse execute() {

        User user = userFacade.getCurrentUser();

        List<PostResponse> myPostList = postRepository.findByJoinListIsIn(Collections.singleton(user.getJoinList()))
                .stream()
                .map(PostResponse::of)
                .collect(Collectors.toList());

        return new PostListResponse(myPostList);
    }
}
