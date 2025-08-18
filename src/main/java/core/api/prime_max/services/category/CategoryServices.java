package core.api.prime_max.services.category;

import core.api.prime_max.dto.request.CategoryResquest;
import core.api.prime_max.dto.response.category.CategoryPayload;
import core.api.prime_max.dto.response.category.CategoryResponse;
import core.api.prime_max.exceptions.category.CategoryAlreadyExist;
import core.api.prime_max.exceptions.category.CategoryDeleteException;
import core.api.prime_max.exceptions.category.CategoryNameIsEmpty;
import core.api.prime_max.exceptions.category.CategoryNotFound;
import core.api.prime_max.models.category.Category;
import core.api.prime_max.repositories.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServices {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryResponse> listAll(String name) {
        List<Category> list = categoryRepository.findAll();

        return list.stream()
                .filter(category -> name == null || name.isBlank() || category.getName().toLowerCase().contains(name.toLowerCase()))
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .toList();
    }

    public CategoryPayload create(CategoryResquest req) {

        if (req.getName().isEmpty()) {
            log.warn("Category name cannot be empty");
            throw new CategoryNameIsEmpty("Category name cannot be empty");
        }

        if (categoryRepository.findByName(req.getName()).isPresent()) {
            log.warn("Category name already exists");
            throw new CategoryAlreadyExist("Category " + req.getName() + " already exists");
        }

        Category category = Category.builder()
                .name(req.getName())
                .build();

        CategoryResponse response = modelMapper.map(categoryRepository.save(category), CategoryResponse.class);

        return new CategoryPayload("Category created successfully", response);
    }

    public CategoryResponse findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        return modelMapper.map(category.orElseThrow(() -> new CategoryNotFound("Category with ID " + id + " not found")), CategoryResponse.class);
    }

    public CategoryPayload update(Long id, CategoryResquest req) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFound("Category with ID " + id + " not found"));


        if (req.getName().isEmpty()) {
            log.warn("Category name cannot be empty");
            throw new CategoryNameIsEmpty("Category name cannot be empty");
        } else if (categoryRepository.findByName(req.getName())
                .filter(c -> !c.getId().equals(id))
                .isPresent()) {
            log.warn("Category name already exists");
            throw new CategoryAlreadyExist("Category " + req.getName() + " already exists");
        }

        category.setName(req.getName());
        category.setUpdatedAt(LocalDateTime.now());
        CategoryResponse response = modelMapper.map(categoryRepository.save(category), CategoryResponse.class);

        return new CategoryPayload("Category updated successfully", response);
    }

    public CategoryPayload delete(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        CategoryResponse response = modelMapper.map(category.orElseThrow(() -> new CategoryNotFound("Category with ID " + id + " not found")), CategoryResponse.class);

        try {
            categoryRepository.delete(category.get());
        } catch (Exception e) {
            throw new CategoryDeleteException("Cannot delete a category. It is being used in another record");
        }

        return new CategoryPayload("Category deleted successfully", response);
    }


}
