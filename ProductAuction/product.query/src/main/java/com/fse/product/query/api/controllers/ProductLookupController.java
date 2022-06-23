package com.fse.product.query.api.controllers;

import com.fse.cqrs.core.infrastructure.QueryDispatcher;
import com.fse.product.query.api.dto.ProductLookupResponse;
import com.fse.product.query.api.queries.FindProductByIdQuery;
import com.fse.product.query.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/productLookup")
public class ProductLookupController {
    private final Logger logger = Logger.getLogger(ProductLookupController.class.getName());

    @Autowired
    private QueryDispatcher queryDispatcher;


    @GetMapping(path = "/byId/{id}")
    public ResponseEntity<ProductLookupResponse> getAccountById(@PathVariable(value = "id") String id) {
        try {
            List<Product> products = queryDispatcher.send(new FindProductByIdQuery(Integer.valueOf(id)));
            if (products == null || products.size() == 0) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            var response = ProductLookupResponse.builder()
                    .product(products)
                    .message("Successfully returned bank account!")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get accounts by ID request!";
            logger.log(Level.SEVERE, safeErrorMessage, e);
            return new ResponseEntity<>(new ProductLookupResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
