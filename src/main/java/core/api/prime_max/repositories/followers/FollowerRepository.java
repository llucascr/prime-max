package core.api.prime_max.repositories.followers;

import core.api.prime_max.models.followers.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Long> {}
