package api_v1.latte_s.user;

import api_v1.latte_s.order.Order;
import lombok.*;

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
@Table
public class User {
    @Id
    @Column(nullable = false)
    private String email;
    private String password;
    private String name;
    private String last_name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Order")
    @ToString.Exclude
    private List<Order> orders;
    private Boolean deleted;
    private LocalDateTime created;
}
