package com.example.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;

    public User join(JoinRequestDto joinRequestDto) {
        userValidator.validate(joinRequestDto);
        String nickname = joinRequestDto.getNickname();
        String password = passwordEncoder.encode(joinRequestDto.getPassword1());
        return userRepository.save(new User(null, nickname, password, null, null));
    }
}
