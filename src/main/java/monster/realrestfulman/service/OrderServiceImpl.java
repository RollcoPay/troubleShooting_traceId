package monster.realrestfulman.service;

import lombok.RequiredArgsConstructor;
import monster.realrestfulman.entity.Order;
import monster.realrestfulman.repository.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
