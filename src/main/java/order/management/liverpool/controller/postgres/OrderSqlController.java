package order.management.liverpool.controller.postgres;

import lombok.RequiredArgsConstructor;
import order.management.liverpool.dto.OrderRequest;
import order.management.liverpool.entity.Order;
import order.management.liverpool.entity.User;
import order.management.liverpool.exception.ResourceNotFoundException;
import order.management.liverpool.service.postgres.OrderSqlService;
import order.management.liverpool.service.postgres.UserSqlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderSqlController {

    private final OrderSqlService service;
    private final UserSqlService userService;

    @GetMapping
    public List<Order> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Order byId(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderRequest request) {
        User user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Order order = new Order();
        order.setCodigoProducto(request.getCodigoProducto());
        order.setCantidad(request.getCantidad());
        order.setPrecio(request.getPrecio());
        order.setUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody OrderRequest request) {
        Order order = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));

        User user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        order.setCodigoProducto(request.getCodigoProducto());
        order.setCantidad(request.getCantidad());
        order.setPrecio(request.getPrecio());
        order.setUser(user);

        return ResponseEntity.ok(service.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
