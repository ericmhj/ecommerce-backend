package com.mozza.backend.infrastructure.adapter;

import com.mozza.backend.domain.model.OrderState;
import com.mozza.backend.infrastructure.entity.OrderEntity;
import com.mozza.backend.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity oe SET oe.orderState = :state WHERE oe.id = :id")
    void updateStrategyById(Long id, OrderState state);

    Iterable <OrderEntity> findByUserEntity(UserEntity userEntity);


}
