package com.example.rightside.domain.post.domain.repository;

import com.example.rightside.domain.post.domain.Join;
import com.example.rightside.domain.post.domain.Post;
import com.example.rightside.domain.post.domain.type.Tag;
import com.example.rightside.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByOrderByIdDesc();


    List<Post> findByTag(Tag tag);

    List<Post> findByUser(User user);

    List<Post> findByTitleContains(String title);

    List<Post> findByJoinListIsIn(Collection<List<Join>> joinList);
}
