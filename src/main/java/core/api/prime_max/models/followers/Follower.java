package core.api.prime_max.models.followers;

import core.api.prime_max.models.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_followers")
public class Follower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameFollower;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
