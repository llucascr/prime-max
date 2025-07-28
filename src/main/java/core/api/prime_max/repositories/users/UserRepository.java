package core.api.prime_max.repositories.users;

import core.api.prime_max.models.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM tb_users u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))",
            nativeQuery = true)
    Page<User> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT * FROM tb_users WHERE email = :email",
            nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);


    /*@Query(value = "SELECT * FROM tb_users WHERE name ILIKE %:name%", nativeQuery = true)
    Page<User> findByName(@Param("name") String name, Pageable pageable);*/



}

