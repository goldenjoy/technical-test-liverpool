package order.management.liverpool.repository.postgres;

import order.management.liverpool.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
