package api_v1.latte_s.order;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class Order {
    @Id
    private String email;
    private UUID order_number;
    private String coffee;
    private String description;
    private Integer quantity;
    private Boolean cart;
    private Boolean deleted;
    private LocalDateTime created;
}
