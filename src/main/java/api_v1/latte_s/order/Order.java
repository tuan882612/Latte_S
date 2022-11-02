package api_v1.latte_s.order;

import api_v1.latte_s.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Order implements Serializable {
    @Id
    @SequenceGenerator(
        name = "order_id_seq",
        sequenceName = "order_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "order_id_seq"
    )
    private Integer id;
    @NaturalId
    @Column(nullable = false)
    private String email;
    private UUID order_number;
    private String coffee;
    private String description;
    private Integer quantity;
    private Boolean cart;
    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id"
    )
    @JsonBackReference
    @ToString.Exclude
    private User user;
    private Boolean deleted;
    private LocalDateTime created;
}
