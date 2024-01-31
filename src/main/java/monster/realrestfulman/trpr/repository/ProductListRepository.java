package monster.realrestfulman.trpr.repository;

import monster.realrestfulman.trpr.entity.Product;
import monster.realrestfulman.trpr.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Robin on 2024/01/28.
 * Description :
 */
public interface ProductListRepository extends JpaRepository<ProductList, Long> {

}
