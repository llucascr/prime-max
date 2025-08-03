package core.api.prime_max.services.category;

import core.api.prime_max.dto.request.CategoryResquest;
import core.api.prime_max.dto.response.CategoryResponse;
import core.api.prime_max.exceptions.category.CategoryAlreadyExist;
import core.api.prime_max.exceptions.category.CategoryNameIsEmpty;
import core.api.prime_max.models.category.Category;
import core.api.prime_max.repositories.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServices {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryResponse create(CategoryResquest req) {

        if(req.getName().isEmpty()) {
            log.warn("Category name cannot be empty");
            throw new CategoryNameIsEmpty("Category name cannot be empty");
        }

        if(categoryRepository.findByName(req.getName()).isPresent()) {
            log.warn("Category name already exists");
            throw new CategoryAlreadyExist("Category " + req.getName() + " already exists");
        }

        Category category = Category.builder()
                .name(req.getName())
                .build();

        return modelMapper.map(categoryRepository.save(category), CategoryResponse.class);
    }

//    public CategoryResponse findByName(String name) {
//        Optional<Category> category = categoryRepository.findByName(name);
//
//
//    }



}
