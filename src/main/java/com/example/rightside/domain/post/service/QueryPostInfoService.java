package com.example.rightside.domain.post.service;

import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.repository.JoinRepository;
import com.example.rightside.domain.post.domain.repository.PostRepository;
import com.example.rightside.domain.post.facade.PostFacade;
import com.example.rightside.domain.post.presentation.dto.response.PostInfoResponse;
import com.example.rightside.domain.user.domain.User;
import com.example.rightside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class QueryPostInfoService {
    private final PostFacade postFacade;
    private final UserFacade userFacade;
    private final JoinRepository joinRepository;

    public PostInfoResponse execute(Long id) {

        User user = userFacade.getCurrentUser();
        Post post = postFacade.getPostById(id);

        boolean isLiked = joinRepository.findByUserAndPost(user, post).isPresent();

        return PostInfoResponse.of(user, post, isLiked);
    }
}
