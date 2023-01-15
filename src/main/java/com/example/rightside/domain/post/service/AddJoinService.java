package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.Join;
import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.repository.JoinRepository;
import com.example.rightside.domain.post.facade.PostFacade;
import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddJoinService {
    private final UserFacade userFacade;
    private final PostFacade postFacade;
    private final JoinRepository joinRepository;

    public void execute(Long id) {
        User user = userFacade.getCurrentUser();
        Post post = postFacade.getPostById(id);

        joinRepository.save(
                Join.builder().post(post).user(user).build()
        );
    }
}
