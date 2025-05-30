package com.mozza.backend.domain.port;

import com.mozza.backend.domain.model.Order;

public interface IOrderRepository {

    Order save (Order order);
    Order findById(Long id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Long id);

    void updateStateById(Long id, String state);
    void deleteById(Long id);



}
