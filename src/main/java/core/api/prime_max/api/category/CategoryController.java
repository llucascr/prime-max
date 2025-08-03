package core.api.prime_max.api.category;

import core.api.prime_max.dto.request.CategoryResquest;
import core.api.prime_max.dto.response.CategoryResponse;
import core.api.prime_max.services.category.CategoryServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryController {

    private final CategoryServices categoryServices;


    @PostMapping(path = "/create")
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryResquest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryServices.create(req));
    }
}
