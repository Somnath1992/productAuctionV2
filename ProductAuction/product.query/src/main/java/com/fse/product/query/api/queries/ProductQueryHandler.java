package com.fse.product.query.api.queries;

import com.fse.cqrs.core.domain.BaseEntity;
import com.fse.product.query.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductQueryHandler implements QueryHandler {
    @Autowired
    private ProductRepository productRepository;



    @Override
    public List<BaseEntity> handle(FindProductByIdQuery query) {
        var productDetails = productRepository.findById(query.getId());
        if (productDetails.isEmpty()) {
            return null;
        }
        List<BaseEntity> productAccountList = new ArrayList<>();
        productAccountList.add(productDetails.get());
        return productAccountList;
    }




}
