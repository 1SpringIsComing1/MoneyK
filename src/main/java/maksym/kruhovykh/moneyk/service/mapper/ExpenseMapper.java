package maksym.kruhovykh.moneyk.service.mapper;

import maksym.kruhovykh.moneyk.dto.ExpenseDto;
import maksym.kruhovykh.moneyk.repository.entity.Expense;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public interface ExpenseMapper extends Mapper<Expense, ExpenseDto> {
}
