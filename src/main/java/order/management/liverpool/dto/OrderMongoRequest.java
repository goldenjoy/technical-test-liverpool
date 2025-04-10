package order.management.liverpool.dto;

import lombok.Data;

@Data
public class OrderMongoRequest {
    private String codigoProducto;
    private int cantidad;
    private double precio;
    private String userId;
}
