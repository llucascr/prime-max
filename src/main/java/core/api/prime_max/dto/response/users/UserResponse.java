package core.api.prime_max.dto.response.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import core.api.prime_max.dto.enums.UserPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private UserPlan plan;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private Boolean active;

}
