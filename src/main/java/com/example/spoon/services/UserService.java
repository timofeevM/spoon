package com.example.spoon.services;

import com.example.spoon.models.User;
import com.example.spoon.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }




    @Override
    public UserDetails loadUserByUsername(String username) {
        if (userRepository.findByUsername(username)!=null){
            return userRepository.findByUsername(username);
        }else {
            throw new UsernameNotFoundException("Не найден пользователь: " + username);
        }
    }
}
