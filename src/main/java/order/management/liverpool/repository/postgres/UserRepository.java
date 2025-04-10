package order.management.liverpool.repository.postgres;

import order.management.liverpool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
