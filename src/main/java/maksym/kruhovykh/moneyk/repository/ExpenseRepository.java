package maksym.kruhovykh.moneyk.repository;

import maksym.kruhovykh.moneyk.repository.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
