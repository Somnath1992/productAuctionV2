package com.fse.product.query.api.queries;


import com.fse.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindProductByIdQuery extends BaseQuery {
    private Integer id;
}
