package com.mozza.backend.infrastructure.adapter;

import com.mozza.backend.domain.model.Product;
import com.mozza.backend.domain.port.IProductRepository;
import com.mozza.backend.infrastructure.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, ProductMapper productMapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productMapper.toProduct(iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProductList(iProductCrudRepository.findAll());
    }

    @Override
    public Product findById(Long id) {
        return productMapper.toProduct(iProductCrudRepository.findById(id).orElseThrow(
                ()->  new RuntimeException("Producto con id_ "+id+"No Existe")
        ));
    }


    @Override
    public void deleteById(Long id) {
        iProductCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Producto con id_ "+id+"No Existe")
        );

        iProductCrudRepository.deleteById(id);

    }
}
