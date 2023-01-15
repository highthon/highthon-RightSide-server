package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.facade.PostFacade;
import com.example.rightside.domain.post.presentation.dto.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdatePostService {
    private final PostFacade postFacade;

    @Transactional
    public void execute(Long id, CreatePostRequest request) {

        Post post = postFacade.getPostById(id);

        postFacade.checkUser(post);

        post.updatePost(request.getTitle(), request.getContent(), request.getLink(), request.getTag());
    }
}