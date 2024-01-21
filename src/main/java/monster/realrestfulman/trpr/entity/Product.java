package monster.realrestfulman.trpr.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Robin on 2023/12/27.
 * Description :
 */
@Entity
@Table(name = "PRODUCT")
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }
}
