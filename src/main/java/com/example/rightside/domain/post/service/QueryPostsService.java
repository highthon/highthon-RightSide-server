package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.presentation.dto.response.PostListResponse;
import com.example.rightside.domain.post.presentation.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryPostsService {

    private final PostRepository postRepository;

    @Transactional
    public PostListResponse execute() {
        List<PostResponse> postList = postRepository.findByOrderByIdDesc()
                .stream()
                .map(PostResponse::of)
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }
}