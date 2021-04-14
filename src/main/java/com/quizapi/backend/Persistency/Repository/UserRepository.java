package com.quizapi.backend.Persistency.Repository;

import java.util.LinkedList;

import com.quizapi.backend.Persistency.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    LinkedList<User> findAllByOrderByUsernameAsc();

    LinkedList<User> findAllByOrderByUsernameDesc();

    User findByUsername(String username);

    void delete(User user);

    void deleteAll();
}
