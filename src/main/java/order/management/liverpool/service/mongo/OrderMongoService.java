package order.management.liverpool.service.mongo;

import order.management.liverpool.document.OrderDocument;
import order.management.liverpool.repository.mongo.OrderMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMongoService {
    private final OrderMongoRepository repository;

    public OrderMongoService(OrderMongoRepository repository) {
        this.repository = repository;
    }

    public List<OrderDocument> findAll() {
        return repository.findAll();
    }

    public Optional<OrderDocument> findById(String id) {
        return repository.findById(id);
    }

    public OrderDocument save(OrderDocument order) {
        return repository.save(order);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
