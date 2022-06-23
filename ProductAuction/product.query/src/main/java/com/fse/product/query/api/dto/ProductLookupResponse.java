package com.fse.product.query.api.dto;


import com.fse.product.common.dto.BaseResponse;
import com.fse.product.query.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class ProductLookupResponse extends BaseResponse {
    private List<Product> product;

    public ProductLookupResponse(String message) {
        super(message);
    }
}
