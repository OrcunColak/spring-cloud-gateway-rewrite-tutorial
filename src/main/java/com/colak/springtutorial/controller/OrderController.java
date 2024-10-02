package com.colak.springtutorial.controller;

import com.colak.springtutorial.dto.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

    // http://localhost:8080/orders/1
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderModel> getOrderById(@PathVariable String orderId, @RequestParam Map<String, String> allParams) {

        // Iterate over all parameters
        allParams.forEach((key, value) ->
                log.info("key : {} value : {}", key, value)
        );

        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderId);
        return ResponseEntity.ok(orderModel);
    }
}
