package manager.tabletap.promoCode;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import manager.tabletap.user.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PromoCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private Integer value;

    @ManyToOne
    private User user;
}
