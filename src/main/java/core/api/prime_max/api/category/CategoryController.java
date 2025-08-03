package core.api.prime_max.api.category;

import core.api.prime_max.dto.request.CategoryResquest;
import core.api.prime_max.dto.response.category.CategoryPayload;
import core.api.prime_max.dto.response.category.CategoryResponse;
import core.api.prime_max.models.category.Category;
import core.api.prime_max.services.category.CategoryServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryController {

    private final CategoryServices categoryServices;

    @GetMapping(path = "/list")
    public ResponseEntity<List<CategoryResponse>> list() {
        return  ResponseEntity.status(HttpStatus.OK).body(categoryServices.listAll());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CategoryPayload> create(@RequestBody CategoryResquest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryServices.create(req));
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<CategoryResponse> findById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryServices.findById(id));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<CategoryPayload> delete(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryServices.delete(id));
    }
}
