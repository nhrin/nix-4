package alevel.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operations_expenses")
@Getter
public class ExpenseCategory extends OperationCategory {

    @ManyToMany(mappedBy = "categories")
    private final List<Expense> operations = new ArrayList<>();

}
