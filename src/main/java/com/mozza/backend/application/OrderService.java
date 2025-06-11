package com.mozza.backend.application;

import com.mozza.backend.domain.model.Order;
import com.mozza.backend.domain.model.OrderState;
import com.mozza.backend.domain.port.IOrderRepository;
import lombok.AllArgsConstructor;



public class OrderService {


    private final IOrderRepository iOrderRepository;

    public OrderService(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    public Order save(Order order) {
        System.out.println(" OrderState.CANCELLED.toString()  "+OrderState.CANCELLED.toString());
        if (order.getOrderState().toString().equals(OrderState.CANCELLED.toString())){
            order.setOrderState(OrderState.CANCELLED);
        }else {
            order.setOrderState(OrderState.CONFIRMED);
        }

        return this.iOrderRepository.save(order);
    }

    public Order findById(Long id) {
        return this.iOrderRepository.findById(id);
    }

    public Iterable<Order> findAll() {
        return this.iOrderRepository.findAll();
    }

    public Iterable<Order> findByUserId(Long id) {
        return this.iOrderRepository.findByUserId(id);
    }

    public void updateStateById(Long id, String state) {
        this.iOrderRepository.updateStateById(id,state);
    }

    public void deleteById(Long id) {

    }
}
