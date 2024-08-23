package com.hycu.bookstore.service;

import com.hycu.bookstore.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto user);
    public List<UserDto> getAllUsers();
    public UserDto getUserById(Long id);
    public UserDto updateUser(UserDto user);
    public UserDto deleteUser(Long id);
}
