package maksym.kruhovykh.moneyk.repository.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
@Table(name = "expense")
@Entity
public class Expense implements Serializable {

    private static final long serialVersionUID = -7549025403505714471L;

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
    @OneToOne
    User user;
    Double price;
    @Column
    String comment;


}
