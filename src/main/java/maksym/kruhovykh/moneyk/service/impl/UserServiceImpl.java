package maksym.kruhovykh.moneyk.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import maksym.kruhovykh.moneyk.dto.UserDto;
import maksym.kruhovykh.moneyk.repository.UserRepository;
import maksym.kruhovykh.moneyk.repository.entity.Category;
import maksym.kruhovykh.moneyk.repository.entity.Expense;
import maksym.kruhovykh.moneyk.repository.entity.User;
import maksym.kruhovykh.moneyk.service.UserService;
import maksym.kruhovykh.moneyk.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static maksym.kruhovykh.moneyk.shared.Constants.ExceptionMessages.COULD_NOT_UPDATE_ENTITY_WITH_ID;
import static maksym.kruhovykh.moneyk.shared.Constants.ExceptionMessages.ENTITY_NOT_FOUND_WITH_ID;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserServiceImpl implements UserService {
    UserRepository repository;
    UserMapper mapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User mappedExpense = mapper.mapDtoToEntity(userDto);
        User expense = repository.save(mappedExpense);
        return mapper.mapEntityToDto(expense);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> {
            String message = String.format(ENTITY_NOT_FOUND_WITH_ID, id);
            log.info(message);
            return new EntityNotFoundException(message);
        });

        return mapper.mapEntityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id,UserDto userDto) {
        if (repository.findById(id).isPresent()) {
            User mappedUser = mapper.mapDtoToEntity(userDto);
            User savedUser = repository.save(mappedUser);
            return mapper.mapEntityToDto(savedUser);
        } else {
            throw new EntityNotFoundException(String.format(COULD_NOT_UPDATE_ENTITY_WITH_ID,id));
        }
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
