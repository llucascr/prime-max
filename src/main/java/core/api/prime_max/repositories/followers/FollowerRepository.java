package core.api.prime_max.repositories.followers;

import core.api.prime_max.models.followers.Follower;
import core.api.prime_max.models.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowerRepository extends JpaRepository<Follower, Long> {

    @Query(value = "SELECT * FROM tb_followers f WHERE f.user_id = :userId", nativeQuery = true)
    Page<Follower> findAllPageble(Pageable pageable, @Param("userId") Long userId);
}
