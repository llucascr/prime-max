package core.api.prime_max.repositories;

import core.api.prime_max.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
