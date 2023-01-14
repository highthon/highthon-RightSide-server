package com.example.rightside.domain.user.domain;

import lombok.*;

import javax.persistence.*;

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
}