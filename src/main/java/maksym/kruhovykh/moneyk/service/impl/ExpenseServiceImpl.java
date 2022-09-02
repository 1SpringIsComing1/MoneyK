package maksym.kruhovykh.moneyk.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import maksym.kruhovykh.moneyk.dto.ExpenseDto;
import maksym.kruhovykh.moneyk.repository.ExpenseRepository;
import maksym.kruhovykh.moneyk.repository.entity.Expense;
import maksym.kruhovykh.moneyk.service.ExpenseService;
import maksym.kruhovykh.moneyk.service.mapper.ExpenseMapper;
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
public class ExpenseServiceImpl implements ExpenseService {
    ExpenseRepository repository;
    ExpenseMapper mapper;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense mappedExpense = mapper.mapDtoToEntity(expenseDto);
        Expense expense = repository.save(mappedExpense);
        return mapper.mapEntityToDto(expense);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense expense = repository.findById(id).orElseThrow(() -> {
            String message = String.format(ENTITY_NOT_FOUND_WITH_ID, id);
            log.info(message);
            return new EntityNotFoundException(message);
        });

        return mapper.mapEntityToDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        return repository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(ExpenseDto expenseDto) {
        if (repository.findById(expenseDto.getId()).isPresent()) {
            Expense mappedExpense = mapper.mapDtoToEntity(expenseDto);
            Expense savedExpense = repository.save(mappedExpense);
            return mapper.mapEntityToDto(savedExpense);
        } else {
            throw new EntityNotFoundException(String.format(COULD_NOT_UPDATE_ENTITY_WITH_ID, expenseDto.getId()));
        }
    }

    @Override
    public void deleteExpenseById(Long id) {
        repository.deleteById(id);
    }
}
