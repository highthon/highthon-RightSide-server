package com.example.rightside.domain.post.presentation.dto;

import com.example.rightside.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.rightside.domain.post.presentation.dto.response.PostInfoResponse;
import com.example.rightside.domain.post.presentation.dto.response.PostListResponse;
import com.example.rightside.domain.post.service.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final CreatePostService createPostService;
    private final QueryPostInfoService queryPostInfoService;
    private final QueryPostsService queryPostsService;
    private final QueryPostsByTagService queryPostsByTagService;
    private final QueryMyPostService queryMyPostService;
    private final QueryPostsByKeywordService queryPostsByKeywordService;
    private final QueryJoinedPostsService queryJoinedPostsService;

    private final DeletePostService deletePostService;
    private final UpdatePostService updatePostService;

    @PostMapping
    public void createPost(@RequestBody @Valid CreatePostRequest request) {
        createPostService.execute(request);
    }

    @GetMapping("/{post-id}")
    public PostInfoResponse queryPostInfo(@PathVariable("post-id") Long id) {
        return queryPostInfoService.execute(id);
    }

    @GetMapping
    public PostListResponse queryPosts() {
        return queryPostsService.execute();
    }

    @GetMapping("/tag")
    public PostListResponse queryPostByTag(@RequestParam(value = "tag")String tag) {
        return queryPostsByTagService.execute(tag);
    }

    @GetMapping("/my")
    public PostListResponse queryMyPosts() {
        return queryMyPostService.execute();
    }

    @GetMapping("/title")
    public PostListResponse queryPostsByKeyword(@RequestParam(value = "title")String title) {
        return queryPostsByKeywordService.execute(title);
    }

    @GetMapping("/joined")
    public PostListResponse queryJoinedPosts() {
        return queryJoinedPostsService.execute();
    }

    @DeleteMapping("/{post-id}")
    public void deletePost(@PathVariable("post-id") Long id) {deletePostService.execute(id);}

    @PatchMapping("/{post-id}")
    public void updatePost(@PathVariable("post-id") Long id, @RequestBody @Valid CreatePostRequest request) {
        updatePostService.execute(id, request);
    }
}
