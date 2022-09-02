package maksym.kruhovykh.moneyk.repository.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
@Table(name = "category")
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 4419994801749960468L;

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Expense> expenses;

}
