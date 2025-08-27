package core.api.prime_max.models.users;

import core.api.prime_max.dto.enums.UserPlan;
import core.api.prime_max.models.followers.Follower;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserPlan plan;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<Follower> followers;

}
