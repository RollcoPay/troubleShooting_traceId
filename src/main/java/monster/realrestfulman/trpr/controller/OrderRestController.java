package monster.realrestfulman.trpr.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import monster.realrestfulman.trpr.aop.TraceInfo;
import monster.realrestfulman.trpr.controller.dto.OrderRequest;
import monster.realrestfulman.trpr.entity.Order;
import monster.realrestfulman.trpr.entity.Product;
import monster.realrestfulman.trpr.entity.ProductList;
import monster.realrestfulman.trpr.repository.ProductListRepository;
import monster.realrestfulman.trpr.service.OrderService;
import monster.realrestfulman.trpr.service.ProductListService;
import monster.realrestfulman.trpr.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;
    private final ProductService productService;
    private final ProductListService productListService;

    public ResponseEntity<?> postorder_1(HttpServletRequest servletRequest, @ModelAttribute OrderRequest request) {
        log.info("주문내역::상품=" + request.getProductName() + ":가격=" + request.getAmount());
        Map<String, String> body = new HashMap<>();
        body.put("msg", "주문 완료!");
        HttpHeaders headers = new HttpHeaders();
        headers.add("traceInfo", servletRequest.getHeader("traceInfo"));
        return ResponseEntity.ok().headers(headers).body(body);
    }

    @PostMapping
    public ResponseEntity<?> postorder_2(@TraceInfo String traceInfo, @RequestBody OrderRequest request) {
        log.info("주문내역::상품=" + request.getProductName() + ":가격=" + request.getAmount());
        Product product = new Product(request.getProductName(), request.getAmount());
        productService.save(product);
        ProductList productList = new ProductList(product);
        productListService.save(productList);
        Order order = new Order(productList, request.getAmount());
        orderService.save(order);
        HttpHeaders headers = new HttpHeaders();
        headers.add("traceInfo", traceInfo);
        Map<String, String> body = new HashMap<>();
        body.put("msg", "주문 완료!");
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(body);
    }
}
