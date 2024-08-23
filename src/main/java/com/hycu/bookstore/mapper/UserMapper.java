package com.hycu.bookstore.mapper;
import com.hycu.bookstore.dto.UserDto;
import com.hycu.bookstore.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Mapping from entity to DTO
    UserDto toDto(User user);

    // Mapping from DTO to entity
    User toEntity(UserDto userDTO);
    // Mapping a list of UserEntity to a list of UserDTO
    List<UserDto> toDtoList(List<User> users);

    // Optionally, mapping a list of UserDTO to a list of UserEntity
    List<User> toEntityList(List<UserDto> userDTOs);
}
