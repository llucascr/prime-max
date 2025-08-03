package core.api.prime_max.dto.request;

import jakarta.persistence.GeneratedValue;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResquest {

    private Long id;
    private String name;

    private LocalDateTime createdAt;
}
