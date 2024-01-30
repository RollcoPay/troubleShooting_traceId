package monster.realrestfulman.trpr.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import monster.realrestfulman.trpr.entity.Order;
import monster.realrestfulman.trpr.entity.Product;
import monster.realrestfulman.trpr.entity.ProductList;
import monster.realrestfulman.trpr.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public Order save2(Map dataMap) {
        int amount = Integer.parseInt((String) dataMap.get("order_1_amount"));
        Order order = new Order(new ProductList(new Product((String) dataMap.get("order_1_name"), amount)), amount);
//        orderRepository.save(order);
        log.info("order : {}",order.toString());
        log.info("TEST : {}", "SAVE2");
        return order;
    }
}
