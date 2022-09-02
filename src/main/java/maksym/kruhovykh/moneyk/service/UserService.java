package maksym.kruhovykh.moneyk.service;

import maksym.kruhovykh.moneyk.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUserById(Long id);
}
