package core.api.prime_max.dto.response.followers;

import core.api.prime_max.models.followers.Follower;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FollowerResponse {

    private String userName;
    private List<ListFollowerResponse> followers;

}
