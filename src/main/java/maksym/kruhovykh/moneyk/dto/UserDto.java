package maksym.kruhovykh.moneyk.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserDto {
    @NonNull
    Long id;
    @NonNull
    String username;
}
