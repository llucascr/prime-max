package core.api.prime_max.repositories.followers;

import core.api.prime_max.models.followers.Follower;
import core.api.prime_max.models.users.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.function.Function;

public interface FollowerRepository extends JpaRepository<Follower, Long> {

    @Query(value = "SELECT * FROM tb_followers f WHERE f.user_id = :userId", nativeQuery = true)
    Page<Follower> findAllPageble(Pageable pageable, @Param("userId") Long userId);

    @Query(value = "SELECT * FROM tb_followers f WHERE f.user_id = :userId AND f.follower_id = :followerId", nativeQuery = true)
    Optional<Follower> findByUserIdFollowerId(@Param("userId") Long userId, @Param("followerId") Long followerId);

}
