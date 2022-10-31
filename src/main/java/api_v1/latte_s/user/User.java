package api_v1.latte_s.user;

import api_v1.latte_s.order.Order;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String name;
    private String last_name;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Order> orders;
    private Boolean deleted;
    private LocalDateTime created;
}
