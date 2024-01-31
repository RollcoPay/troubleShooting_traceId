package monster.realrestfulman.trpr.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import monster.realrestfulman.trpr.aop.TraceIdAnnotation;
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

import javax.servlet.http.HttpServletRequest;
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


    @TraceIdAnnotation
    @GetMapping("/ready")
    public String ready(Model model, HashMap dataMap, HttpServletRequest request) {
        log.info((String) request.getAttribute("TRACE_ID"));
        dataMap.put("TRACE_ID",(String) request.getAttribute("TRACE_ID"));
        model.addAttribute("dataMap", dataMap);
        return "ready";
    }


    @TraceIdAnnotation
    @PostMapping("/pay")
    public String pay(Model model, @RequestParam Map<String, Object> dataMap, HttpServletRequest request) {
        Order order = orderService.save2(dataMap);
        log.info(order.toString());
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("order", order);
        return "pay";
    }


    @TraceIdAnnotation
    @PostMapping("/auth")
    public String auth(Model model, @RequestParam Map<String, Object> dataMap, HttpServletRequest request) {
        Order order = orderService.save2(dataMap);
        log.info(order.toString());
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("order", order);
        return "auth";
    }



    @TraceIdAnnotation
    @PostMapping("/settle")
    @ResponseBody
    public ResponseEntity<Map> settle(Model model, @RequestBody Map<String, String> dataMap) {
//        MDC.put("TRACE_ID", (String) dataMap.get("TRACE_ID"));  //// -> "AOP로 빼야하는 부분."

        log.info("settle , dataMap  : {}", dataMap);
        model.addAttribute("dataMap", dataMap);

        return ResponseEntity.ok(dataMap);
    }
}
