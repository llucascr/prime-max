package core.api.prime_max.dto.response.followers;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetFollowerResponse {

    private Long id;
    private String nameFollower;

}
