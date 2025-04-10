package order.management.liverpool.controller.mongo;

import lombok.RequiredArgsConstructor;
import order.management.liverpool.document.OrderDocument;
import order.management.liverpool.document.UserDocument;
import order.management.liverpool.dto.OrderMongoRequest;
import order.management.liverpool.exception.ResourceNotFoundException;
import order.management.liverpool.service.mongo.OrderMongoService;
import order.management.liverpool.service.mongo.UserMongoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mongo/orders")
@RequiredArgsConstructor
public class OrderMongoController {

    private final OrderMongoService service;
    private final UserMongoService userService;

    @GetMapping
    public List<OrderDocument> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderDocument byId(@PathVariable String id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }

    @PostMapping
    public ResponseEntity<OrderDocument> create(@RequestBody OrderMongoRequest request) {
        UserDocument user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        OrderDocument order = new OrderDocument();
        order.setCodigoProducto(request.getCodigoProducto());
        order.setCantidad(request.getCantidad());
        order.setPrecio(request.getPrecio());
        order.setUserId(user.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDocument> update(@PathVariable String id, @RequestBody OrderMongoRequest request) {
        OrderDocument order = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));

        UserDocument user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        order.setCodigoProducto(request.getCodigoProducto());
        order.setCantidad(request.getCantidad());
        order.setPrecio(request.getPrecio());
        order.setUserId(user.getId());

        return ResponseEntity.ok(service.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
