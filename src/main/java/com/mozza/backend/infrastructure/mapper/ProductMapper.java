package com.mozza.backend.infrastructure.mapper;

import com.mozza.backend.domain.model.Product;
import com.mozza.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings(

            {       @Mapping(source = "id",target = "id"),
                    @Mapping(source = "name",target = "id"),
                    @Mapping(source = "code",target = "id"),
                    @Mapping(source = "description",target = "id"),
                    @Mapping(source = "urlImage",target = "id"),
                    @Mapping(source = "price",target = "id"),
                    @Mapping(source = "dateCreated",target = "id"),
                    @Mapping(source = "dateUpdated",target = "id"),
                    @Mapping(source = "userID",target = "id"),
                    @Mapping(source = "categoryId",target = "id"),




            }
    )

    Product toProduct(ProductEntity productEntity);

    Iterable<Product> toProducts(Iterable<ProductEntity> productEntities);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);





}
