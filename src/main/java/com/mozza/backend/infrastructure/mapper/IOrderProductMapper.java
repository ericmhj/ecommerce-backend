package com.mozza.backend.infrastructure.mapper;


import com.mozza.backend.domain.model.OrderProduct;
import com.mozza.backend.infrastructure.entity.OrderProductEntity;
import com.sun.deploy.panel.ITreeNode;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IOrderProductMapper {

    @Mappings(
            {
                    @Mapping(source ="id", target = "id"),
                    @Mapping(source="quantity",target = "quantity"),
                    @Mapping(source="price",target = "price"),
                    @Mapping(source="productId",target = "productId")
            }
    )

    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);
    Iterable <OrderProduct> toOrderProductList(Iterable<OrderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);

}
