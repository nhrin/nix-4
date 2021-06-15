package alevel.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import java.time.Clock;
import java.time.Instant;

@Entity
@Table(name = "operations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("CASE WHEN amount > 0 THEN 'income' ELSE 'expense' END")
@Getter
@Setter
@AllArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "account_id")
    private Account account;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Instant timestamp;

    public Operation() {
    }

    public Operation(Account account, Long amount) {
        this.account = account;
        this.amount = amount;
        this.timestamp = Instant.now(Clock.systemUTC());
    }
}
