package com.mozza.backend.infrastructure.adapter;


import com.mozza.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository <ProductEntity,Long>{

}
