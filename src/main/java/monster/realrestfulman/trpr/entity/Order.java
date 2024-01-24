package monster.realrestfulman.trpr.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Robin on 2023/12/22.
 * Description :
 */
@Entity
@Table(name = "ORDER")
@Getter
@NoArgsConstructor
@ToString
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
