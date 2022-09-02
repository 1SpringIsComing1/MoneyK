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
@Table(name = "user")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -7368093263987239230L;

    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String username;
}
