package alevel.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operations_incomes")
@Getter
public class IncomeCategory extends OperationCategory {

    @ManyToMany(mappedBy = "categories")
    private final List<Income> operations = new ArrayList<>();

}
