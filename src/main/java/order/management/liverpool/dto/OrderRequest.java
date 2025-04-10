package order.management.liverpool.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String codigoProducto;
    private int cantidad;
    private double precio;
    private Long userId;
}
