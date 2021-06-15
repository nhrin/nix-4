package alevel.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@DiscriminatorValue("expenses")
@Getter
public class Expense extends Operation {

    @ManyToMany
    @JoinTable(
            name = "expense_categories_of_operations",
            joinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private final Set<ExpenseCategory> categories = new HashSet<>();

}
