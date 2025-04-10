package order.management.liverpool.controller.postgres;

import lombok.RequiredArgsConstructor;
import order.management.liverpool.entity.User;
import order.management.liverpool.exception.ResourceNotFoundException;
import order.management.liverpool.service.postgres.UserSqlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserSqlController {

    private final UserSqlService service;

    @GetMapping
    public List<User> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User byId(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User existing = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        existing.setNombre(user.getNombre());
        existing.setApellidoPaterno(user.getApellidoPaterno());
        existing.setApellidoMaterno(user.getApellidoMaterno());
        existing.setCorreoElectronico(user.getCorreoElectronico());
        existing.setDireccionEnvio(user.getDireccionEnvio());

        return ResponseEntity.ok(service.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
