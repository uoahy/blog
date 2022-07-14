package com.example.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public User join(@RequestBody JoinRequestDto joinRequestDto) {
        return userService.join(joinRequestDto);
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }
}
