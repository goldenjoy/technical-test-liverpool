package order.management.liverpool.repository.mongo;

import order.management.liverpool.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserDocument, String> {}
