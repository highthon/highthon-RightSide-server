package com.example.rightside.domain.post.facade;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.exception.PostNotFoundException;
import com.example.rightside.domain.user.exception.InvalidUserException;
import com.example.rightside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PostFacade {

    private final UserFacade userFacade;
    private final PostRepository postRepository;

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }

    public void checkUser(Post post) {
        if(!userFacade.getCurrentUser().equals(post.getUser()))
            throw InvalidUserException.EXCEPTION;
    }

}