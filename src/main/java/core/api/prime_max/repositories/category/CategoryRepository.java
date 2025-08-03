package core.api.prime_max.repositories.category;

import core.api.prime_max.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select id, name, created_at, updated_at from tb_category where name = :name", nativeQuery = true)
    Optional<Category> findByName(@Param("name") String name);
}
