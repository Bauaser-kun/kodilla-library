package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.UserDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAccountCreated()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAccountCreated()
        );
    }

    public List<UserDto> mapToUserDto(final List<User> users) {
    return users.stream()
            .map(this::mapToUserDto)
            .collect(Collectors.toList());
    }
}
