package monster.realrestfulman.trpr.repository;

import monster.realrestfulman.trpr.entity.Order;
import monster.realrestfulman.trpr.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Robin on 2024/01/28.
 * Description :
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
