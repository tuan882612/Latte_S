package api_v1.latte_s.user;

import api_v1.latte_s.order.Order;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="User")
public class User {
    @Id
    private String email;
    private String password;
    private String name;
    private String last_name;
    @OneToMany(fetch= FetchType.EAGER)
    private List<Order> orders;
    private Boolean deleted;
    private LocalDateTime created;
}
