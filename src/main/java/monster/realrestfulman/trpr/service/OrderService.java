package monster.realrestfulman.trpr.service;

import monster.realrestfulman.trpr.entity.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
public interface OrderService {
    Order save(Order order);

    Order save2(Map dataMap);
}
