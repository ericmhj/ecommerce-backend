package com.mozza.backend.infrastructure.rest;


import com.mozza.backend.application.OrderService;
import com.mozza.backend.domain.model.Order;
import com.mozza.backend.infrastructure.mapper.IOrderMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
        public ResponseEntity<Order> save(@RequestBody Order order){
        System.out.println("Order  "+order );
        return ResponseEntity.ok(this.orderService.save(order));
    }



    @PostMapping("/update/state/order")
    public ResponseEntity<Order> updateStateById(@RequestParam Long id,@RequestParam String state){
        this.orderService.updateStateById(id,state);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Order>> findAll(){
        return ResponseEntity.ok(this.orderService.findAll());

    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<Iterable<Order>> findByUserId(@PathVariable Long id){
        return ResponseEntity.ok(this.orderService.findByUserId(id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){

        return ResponseEntity.ok(this.orderService.findById(id));

    }

}
