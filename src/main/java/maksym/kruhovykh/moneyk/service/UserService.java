package maksym.kruhovykh.moneyk.service;

import maksym.kruhovykh.moneyk.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto UserDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto UserDto);

    void deleteUserById(Long id);
}
