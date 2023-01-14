package com.example.rightside.domain.user.domain;

import com.example.rightside.domain.post.domain.Post;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> postList;
}