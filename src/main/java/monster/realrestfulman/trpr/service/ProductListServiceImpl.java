package monster.realrestfulman.trpr.service;

import lombok.RequiredArgsConstructor;
import monster.realrestfulman.trpr.entity.ProductList;
import monster.realrestfulman.trpr.repository.ProductListRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Robin on 2024/01/28.
 * Description :
 */
@Service
@RequiredArgsConstructor
public class ProductListServiceImpl implements ProductListService {
    private final ProductListRepository productListRepository;

    @Override
    public ProductList save(ProductList product) {
        return productListRepository.save(product);
    }
}
