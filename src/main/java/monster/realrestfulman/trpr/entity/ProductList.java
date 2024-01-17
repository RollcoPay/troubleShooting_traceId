package monster.realrestfulman.trpr.entity;

import jakarta.persistence.*;

/**
 * Created by Robin on 2023/12/27.
 * Description :
 */
@Entity
@Table(name = "PRODUCT_LIST")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductList(Product product) {
        this.product = product;
    }
}
