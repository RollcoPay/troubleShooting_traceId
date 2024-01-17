package monster.realrestfulman.entity;

import jakarta.persistence.*;
import lombok.Getter;

/**
 * Created by Robin on 2023/12/22.
 * Description :
 */
@Entity
@Table(name = "ORDER")
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_list_id")
    private ProductList productList;
    @Column
    private int totalAmount;

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public Order(ProductList productList, int totalAmount) {
        this.productList = productList;
        this.totalAmount = totalAmount;
    }
}
