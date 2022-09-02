package maksym.kruhovykh.moneyk.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryDto {
    Long id;
    @NotNull
    String categoryName;

}
