package core.api.prime_max.repositories.category;

import core.api.prime_max.models.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "select id, name, created_at, updated_at from tb_category " +
            "where (:name is null or lower(name) like %:name%)", nativeQuery = true)
    Page<Category> listAll(@Param("name") String name, PageRequest pageable);

    @Query(value = "select id, name, created_at, updated_at from tb_category where lower(name) = :name", nativeQuery = true)
    Optional<Category> findByName(@Param("name") String name);
}
