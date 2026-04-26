package com.simplify.restservices.services;

import com.simplify.restservices.entities.User;
import com.simplify.restservices.exceptions.UserExistsException;
import com.simplify.restservices.exceptions.UserNotFoundException;
import com.simplify.restservices.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        Optional<User> dbUser = this.userRepository.findByUsername(user.getUsername());
        if(dbUser.isPresent()) {
            throw new UserExistsException("El usuario: '" + user.getUsername() + "' ya existe en el repositorio.");
        }
        return this.userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }

        throw new UserNotFoundException("Usuario con id: " + id + " no encontrado");
    }

    public User updateUserById(Long id, User user) {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User dbUser = optionalUser.get();
            dbUser.setUsername(user.getUsername());
            dbUser.setEmail(user.getEmail());
            dbUser.setFirstname(user.getFirstname());
            dbUser.setLastname(user.getLastname());
            dbUser.setRole(user.getRole());
            dbUser.setSsn(user.getSsn());

            return this.userRepository.save(dbUser);
        }

        throw new UserNotFoundException("Usuario con id: " + id + " no encontrado");
    }

    public void deleteUserById(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()) {
            this.userRepository.deleteById(id);
        }

        throw new UserNotFoundException("Usuario con id: " + id + " no encontrado");
    }

    public User findUserByUsername(String username) {
        Optional<User> dbUser = this.userRepository.findByUsername(username);
        if(dbUser.isPresent()) {
            return dbUser.get();
        }
        throw new UserNotFoundException("Usuario con usename: " + username + " no encontrado");
    }
}
