package order.management.liverpool.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
@Data
public class OrderDocument {
    @Id
    private String id;
    private String codigoProducto;
    private int cantidad;
    private double precio;
    private String userId;
}
