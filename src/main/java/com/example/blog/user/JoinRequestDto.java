package com.example.blog.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JoinRequestDto {

    private String nickname;
    private String password1;
    private String password2;
}
