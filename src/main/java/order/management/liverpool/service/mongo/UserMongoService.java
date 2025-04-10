package order.management.liverpool.service.mongo;

import order.management.liverpool.document.UserDocument;
import order.management.liverpool.repository.mongo.UserMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMongoService {
    private final UserMongoRepository repository;

    public UserMongoService(UserMongoRepository repository) {
        this.repository = repository;
    }

    public List<UserDocument> findAll() {
        return repository.findAll();
    }

    public Optional<UserDocument> findById(String id) {
        return repository.findById(id);
    }

    public UserDocument save(UserDocument user) {
        return repository.save(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
