package core.api.prime_max.dto.response.followers;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowerResponse {

    private String userName;
    private Set<SetFollowerResponse> followers;

}
