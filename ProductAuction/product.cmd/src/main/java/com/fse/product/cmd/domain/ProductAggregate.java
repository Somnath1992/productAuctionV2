package com.fse.product.cmd.domain;

import com.fse.cqrs.core.domain.AggregateRoot;
import com.fse.product.cmd.api.commands.AddProductCommand;
import com.fse.product.common.dto.ProductCategory;


import com.fse.product.common.events.ProductClosedEvent;
import com.fse.product.common.events.ProductOpenedEvent;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
public class ProductAggregate extends AggregateRoot {
    private Boolean active;
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public ProductAggregate(AddProductCommand command) {

        boolean futureOrNot = getFutureOrNot(command.getBidEndDate());
        ProductCategory cat = ProductCategory.valueOf(command.getCategory());
        if(futureOrNot) {
            raiseEvent(ProductOpenedEvent.builder()
                    .id(command.getId())
                    .productId(command.getProductId())
                    .productName(command.getProductName())
                    .category(cat.getDisplayName())
                    .shortDescription(command.getShortDescription())
                    .startingPrice(command.getStartingPrice())
                    .bidEndDate(command.getBidEndDate())
                    .description(command.getDescription())
                    .build());
        }
    }

    public void apply(ProductOpenedEvent event) {
        this.id = event.getId();
        this.active = true;
    }

    private static boolean getFutureOrNot(Timestamp ts)
    {
        if(ts.after(new Timestamp(System.currentTimeMillis())))
            return true;
        else
            return false;
    }


    public void deleteProduct() {
        if (!this.active) {
            throw new IllegalStateException("The bank account has already been closed!");
        }
        raiseEvent(ProductClosedEvent.builder()
                .id(this.id)
                .build());
    }

    public void apply(ProductClosedEvent event) {
        this.id = event.getId();
        this.active = false;
    }


}
