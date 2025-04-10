package order.management.liverpool.repository.mongo;

import order.management.liverpool.document.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderMongoRepository extends MongoRepository<OrderDocument, String> {}

