package com.mozza.backend.application;

import com.mozza.backend.domain.model.Product;
import com.mozza.backend.domain.port.IProductRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ProductService {


    private final IProductRepository iProductRepository;
    private final UploadFile uploadFile;

    public ProductService(IProductRepository iProductRepository, UploadFile uploadFile) {
        this.iProductRepository = iProductRepository;
        this.uploadFile = uploadFile;
    }

    @Transactional
    public Product save(Product product, MultipartFile multipartFile) throws IOException {

        if (product.getId() !=0){//product Already Exists
            if(multipartFile == null){
                product.setUrlImage(product.getUrlImage());
            }else{
                product.setUrlImage(uploadFile.upload(multipartFile));
            }
        }else {
            product.setUrlImage(uploadFile.upload(multipartFile));

        }



        return iProductRepository.save(product);
    }


    public Product findById(Long id){

        return this.iProductRepository.findById(id);
    }
    public Iterable<Product>findAll(){

        return this.iProductRepository.findAll();

    }


    public void deleteById(Long id){

        this.iProductRepository.deleteById(id);
    }


}
