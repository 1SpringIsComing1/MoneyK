package maksym.kruhovykh.moneyk.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenseDto {
    @NotNull
    Long id;
    @NotNull
    Double price;
    String comment;
    @NonNull
    Long categoryId;
    @NonNull
    Long userId;
}
