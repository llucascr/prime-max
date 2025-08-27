package core.api.prime_max.dto.request.followers;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowerRequest {

    @NotBlank
    private Long followId;

    @NotBlank
    private Long userId;

}
