package com.mozza.backend.infrastructure.adapter;

import com.mozza.backend.application.OrderService;
import com.mozza.backend.domain.model.Order;
import com.mozza.backend.domain.model.OrderState;
import com.mozza.backend.domain.port.IOrderRepository;
import com.mozza.backend.infrastructure.entity.OrderEntity;
import com.mozza.backend.infrastructure.entity.UserEntity;
import com.mozza.backend.infrastructure.mapper.IOrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCrudRepositoryImpl implements IOrderRepository {

    private final IOrderCrudRepository iOrderCrudRepository;
    private final IOrderMapper iOrderMapper;

    public OrderCrudRepositoryImpl(IOrderCrudRepository iOrderCrudRepository, IOrderMapper iOrderMapper) {
        this.iOrderCrudRepository = iOrderCrudRepository;
        this.iOrderMapper = iOrderMapper;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = this.iOrderMapper.toOrderEntity(order);
        orderEntity.getOrderProducts().forEach(
                orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)

        );

        return iOrderMapper.toOrder(this.iOrderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Long id) {

        return iOrderMapper.toOrder(this.iOrderCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Order with id "+id +"no existe" )    ));
    }

    @Override
    public Iterable<Order> findAll() {
        return iOrderMapper.toOrderList(this.iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Long userId) {
        UserEntity  userEntity = new UserEntity();
        userEntity.setId(userId);

        //Iterable<OrderEntity> listOrder =  this.iOrderCrudRepository.findByUserEntity(userEntity);
        return iOrderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateById(Long id, String state) {
        if(state.equals(OrderState.CANCELLED)){
            iOrderCrudRepository.updateStrategyById(id,OrderState.CANCELLED);
        }else{
            iOrderCrudRepository.updateStrategyById(id,OrderState.CONFIRMED);
        }

    }

    @Override
    public void deleteById(Long id) {

    }
}
