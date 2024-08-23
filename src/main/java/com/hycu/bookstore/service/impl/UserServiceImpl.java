package com.hycu.bookstore.service.impl;

import com.hycu.bookstore.dto.UserDto;
import com.hycu.bookstore.entity.User;
import com.hycu.bookstore.exception.InvalidInputException;
import com.hycu.bookstore.repository.UserRepository;
import com.hycu.bookstore.service.UserService;
import com.hycu.bookstore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            throw new InvalidInputException("Username can't be empty");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new InvalidInputException("Password can't be empty");
        }
        User newUser = userRepository.save(getUserEntity(user));
        return getUserDto(newUser);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return convertToUserDtoList(userList);
    }
    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return getUserDto(user.get());
        }
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setAddress(userDto.getAddress());
            user.setUserType(userDto.getUserType());
            user.setActive(userDto.isActive());
            user.setProfilePicture(userDto.getProfilePicture());
            User updatedUser = userRepository.save(user);

            return getUserDto(updatedUser);
        }
        return null;
    }

    @Override
    public UserDto deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDto userDto = null;
        if (user.isPresent()) {
            userRepository.deleteById(id);
            userDto = getUserDto(user.get());
        }
        return userDto;
    }

    public UserDto getUserDto(User userEntity) {
        return userMapper.toDto(userEntity);
    }

    public User getUserEntity(UserDto userDTO) {
        return userMapper.toEntity(userDTO);
    }

    public List<UserDto> convertToUserDtoList(List<User> userEntities) {
        return userMapper.toDtoList(userEntities);
    }

    public List<User> convertToUserEntityList(List<UserDto> userDTOs) {
        return userMapper.toEntityList(userDTOs);
    }


}
