package core.api.prime_max.repositories;

import core.api.prime_max.models.TestFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestFlowRepository extends JpaRepository<TestFlow, Long> {
}
