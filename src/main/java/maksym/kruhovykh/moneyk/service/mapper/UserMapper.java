package maksym.kruhovykh.moneyk.service.mapper;

import maksym.kruhovykh.moneyk.dto.UserDto;
import maksym.kruhovykh.moneyk.repository.entity.User;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public interface UserMapper extends Mapper<User, UserDto> {
}
