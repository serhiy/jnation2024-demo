package com.onlinebrewery.user.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.onlinebrewery.user.domain.User;



@Repository
public class UserRepository {
    public Optional<User> findUser(Integer id) {
        return Optional.of(
                new User(id, "Customer " + id, "Somewhere on Earth" )
        );
    }
}
