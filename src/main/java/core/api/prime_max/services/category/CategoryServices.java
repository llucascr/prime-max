package core.api.prime_max.services.category;

import core.api.prime_max.dto.request.CategoryResquest;
import core.api.prime_max.dto.response.CategoryResponse;
import core.api.prime_max.models.category.Category;
import core.api.prime_max.repositories.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServices {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryResponse create(CategoryResquest req) {

        if(req.getName().isEmpty()) {
            System.out.println("name is empty");
        }

        Category category = Category.builder()
                .name(req.getName())
                .createdAt(LocalDateTime.now())
                .build();

        return modelMapper.map(categoryRepository.save(category), CategoryResponse.class);
    }



}
