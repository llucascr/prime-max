package core.api.prime_max.dto.response.followers;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListFollowerResponse {

    private Long id;
    private String nameFollower;

}
