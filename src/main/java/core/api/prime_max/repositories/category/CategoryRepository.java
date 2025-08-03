package core.api.prime_max.repositories.category;

import core.api.prime_max.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
