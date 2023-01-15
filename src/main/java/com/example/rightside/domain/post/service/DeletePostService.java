package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.facade.PostFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DeletePostService {
    private final PostFacade postFacade;
    private final PostRepository postRepository;

    @Transactional
    public void execute(Long id) {

        Post post = postFacade.getPostById(id);

        postFacade.checkUser(post);

        postRepository.delete(postFacade.getPostById(id));
    }
}
