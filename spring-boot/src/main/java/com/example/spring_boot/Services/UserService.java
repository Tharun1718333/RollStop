package com.example.spring_boot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.Models.aspnetuser;
import com.example.spring_boot.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<aspnetuser> getAllUsers() {
        return userRepository.findAll();
    }

    public aspnetuser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public aspnetuser saveUser(aspnetuser user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public aspnetuser getFirstUserByName(String name) {
        return userRepository.findFirstByName(name).orElse(null);
    }
}
