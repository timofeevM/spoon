package com.example.spoon.repositorys;

import com.example.spoon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String user);
}
