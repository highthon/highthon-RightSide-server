package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.domain.type.Tag;
import com.example.rightside.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CreatePostService {

    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreatePostRequest request) {

        User user = userFacade.getCurrentUser();

        postRepository.save(
                Post.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .link(request.getLink())
                        .tag(request.getTag())
                        .user(user)
                        .build()
        );
    }
}