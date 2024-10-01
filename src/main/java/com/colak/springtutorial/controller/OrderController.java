package com.colak.springtutorial.controller;

import com.colak.springtutorial.dto.OrderModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // http://localhost:8080/orders/1
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderModel> getOrderById(@PathVariable String orderId) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderId);
        return ResponseEntity.ok(orderModel);
    }
}
