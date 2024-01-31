package monster.realrestfulman.trpr.service;

import lombok.RequiredArgsConstructor;
import monster.realrestfulman.trpr.entity.Product;
import monster.realrestfulman.trpr.repository.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Robin on 2024/01/28.
 * Description :
 */

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
