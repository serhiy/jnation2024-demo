package com.onlinebrewery.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onlinebrewery.user.domain.User;
import com.onlinebrewery.user.repo.UserRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getUser(Integer id) {
        double random = Math.random();
        if (random > 0.75) {
            throw new IllegalArgumentException("Nothing personal. This request was destined to fail.");
        }

        try {
            Thread.sleep((long) (5000 * random));
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return userRepository.findUser(id);
    }
}
