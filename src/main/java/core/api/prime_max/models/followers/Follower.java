package core.api.prime_max.models.followers;

import core.api.prime_max.models.users.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_followers")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameUser;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

}
