package com.example.rightside.domain.post.domain.repository;

import com.example.rightside.domain.post.domain.Join;
import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JoinRepository extends CrudRepository<Join, Long> {
    Optional<Join> findByUserAndPost(User user, Post post);
}
