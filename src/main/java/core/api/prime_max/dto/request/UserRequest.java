package core.api.prime_max.dto.request;


import core.api.prime_max.dto.enums.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Plan plan;

    private LocalDateTime createAt;

    private Boolean active;

}
