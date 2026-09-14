package com.risheek.disastermanagement.service;

import com.risheek.disastermanagement.dto.RegisterRequest;
import com.risheek.disastermanagement.dto.UpdateUserRequest;
import com.risheek.disastermanagement.dto.UserResponse;
import com.risheek.disastermanagement.entity.Role;
import com.risheek.disastermanagement.entity.User;
import com.risheek.disastermanagement.exception.EmailAlreadyExistsException;
import com.risheek.disastermanagement.exception.UserNotFoundException;
import com.risheek.disastermanagement.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse getCurrentUser() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        return UserResponse.from(user);
    }

    public UserResponse updateCurrentUser(@Valid UpdateUserRequest request) {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        user.setUsername(request.getUsername());

        userRepository.save(user);

        return UserResponse.from(user);
    }

    public UserResponse createUser(@Valid RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.FIELDRESPONDER);

        userRepository.save(user);

        return UserResponse.from(user);
    }
}