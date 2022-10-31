package api_v1.latte_s.order;

import api_v1.latte_s.user.User;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    @Column(nullable = false, unique = true)
    private String email;
    private UUID order_number;
    private String coffee;
    private String description;
    private Integer quantity;
    private Boolean cart;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private User user;
    private Boolean deleted;
    private LocalDateTime created;
}
