package api_v1.latte_s.user;

import api_v1.latte_s.order.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class User implements Serializable {
    @Id
    @SequenceGenerator(
        name = "user_id_seq",
        sequenceName = "user_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_seq"
    )
    private Integer id;
    @NaturalId
    @Column(nullable = false)
    private String email;
    private String password;
    private String name;
    private String last_name;
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JsonManagedReference
    @ToString.Exclude
    private List<Order> orders;
    private Boolean deleted;
    private LocalDateTime created;
}
