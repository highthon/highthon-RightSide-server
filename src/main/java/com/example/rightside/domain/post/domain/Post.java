package com.example.rightside.domain.post.domain;

import com.example.rightside.domain.post.domain.type.Tag;
import com.example.rightside.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Tag tag;

    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Join> joinList;


    public void updatePost(String title, String content, String link, Tag tag) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.tag = tag;
    }
}