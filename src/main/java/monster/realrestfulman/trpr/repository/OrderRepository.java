package monster.realrestfulman.trpr.repository;

import monster.realrestfulman.trpr.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
