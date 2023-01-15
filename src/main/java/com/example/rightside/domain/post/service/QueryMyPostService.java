package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.presentation.dto.response.PostListResponse;
import com.example.rightside.domain.post.presentation.dto.response.PostResponse;
import com.example.rightside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMyPostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public PostListResponse execute() {

        List<PostResponse> myPostList = postRepository.findByUser(userFacade.getCurrentUser())
                .stream()
                .map(PostResponse::of)
                .collect(Collectors.toList());

        return new PostListResponse(myPostList);
    }
}