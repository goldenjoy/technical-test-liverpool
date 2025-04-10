package order.management.liverpool.controller.mongo;

import lombok.RequiredArgsConstructor;
import order.management.liverpool.document.UserDocument;
import order.management.liverpool.exception.ResourceNotFoundException;
import order.management.liverpool.service.mongo.UserMongoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mongo/users")
@RequiredArgsConstructor
public class UserMongoController {

    private final UserMongoService service;

    @GetMapping
    public List<UserDocument> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDocument byId(@PathVariable String id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    @PostMapping
    public ResponseEntity<UserDocument> create(@RequestBody UserDocument user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDocument> update(@PathVariable String id, @RequestBody UserDocument user) {
        UserDocument existing = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        existing.setNombre(user.getNombre());
        existing.setApellidoPaterno(user.getApellidoPaterno());
        existing.setApellidoMaterno(user.getApellidoMaterno());
        existing.setCorreoElectronico(user.getCorreoElectronico());
        existing.setDireccionEnvio(user.getDireccionEnvio());

        return ResponseEntity.ok(service.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
