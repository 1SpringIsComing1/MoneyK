package maksym.kruhovykh.moneyk.service;

import maksym.kruhovykh.moneyk.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(ExpenseDto expenseDto);

    void deleteExpenseById(Long id);
}
