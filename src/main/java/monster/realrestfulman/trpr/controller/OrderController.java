package monster.realrestfulman.trpr.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import monster.realrestfulman.trpr.aop.TraceInfo;
import monster.realrestfulman.trpr.controller.dto.OrderRequest;
import monster.realrestfulman.trpr.entity.Order;
import monster.realrestfulman.trpr.entity.Product;
import monster.realrestfulman.trpr.entity.ProductList;
import monster.realrestfulman.trpr.service.OrderService;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @GetMapping("/ready")
    public String ready(Model model, HashMap dataMap) {
        dataMap.put("TRACE_ID", MDC.get("TRACE_ID"));

        model.addAttribute("dataMap", dataMap);
        return "ready";
    }


    @GetMapping("/pay")
    public String pay(Model model, @RequestParam Map<String, Object> dataMap) {
        MDC.put("TRACE_ID", (String) dataMap.get("TRACE_ID"));  //// -> "AOP로 빼야하는 부분."

        Order order = orderService.save2(dataMap);
        log.info(order.toString());
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("order", order);
        return "pay";
    }


    @PostMapping("/settle")
    @ResponseBody
    public ResponseEntity<Map> settle(Model model, @RequestBody Map<String, String> dataMap) {
        MDC.put("TRACE_ID", (String) dataMap.get("TRACE_ID"));  //// -> "AOP로 빼야하는 부분."

        log.info("settle , dataMap  : {}", dataMap.toString());
        model.addAttribute("dataMap", dataMap);

        return ResponseEntity.ok(dataMap);
    }
}
