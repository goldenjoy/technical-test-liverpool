package order.management.liverpool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoProducto;
    private int cantidad;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
