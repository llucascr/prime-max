package core.api.prime_max.dto.response.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryPayload {

    private String msg;
    private CategoryResponse category;

    public CategoryPayload(String msg, CategoryResponse category) {
        this.msg = msg;
        this.category = category;
    }

}
