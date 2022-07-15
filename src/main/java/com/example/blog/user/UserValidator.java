package com.example.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class UserValidator {

    private final String nicknamePattern = "[\\w]{3,}";
    private final String passwordPattern = "\\S{4,}";
    private final UserRepository userRepository;

    private void validateNickname(String nickname) {
        if (!Pattern.matches(nicknamePattern, nickname)) {
            throw new IllegalArgumentException("닉네임 조건 만족 X");
        }
        if (userRepository.findByNickname(nickname).isPresent()) {
            throw new IllegalArgumentException("닉네임 중복");
        }
    }

    private void validatePassword(String password1, String password2) {
        if (!Pattern.matches(passwordPattern, password1)) {
            throw new IllegalArgumentException("비밀번호 조건 만족 X");
        }
        if (!password1.equals(password2)) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
    }

    public void validate(JoinRequestDto joinRequestDto) {
        validateNickname(joinRequestDto.getNickname());
        validatePassword(joinRequestDto.getPassword1(), joinRequestDto.getPassword2());
    }
}
