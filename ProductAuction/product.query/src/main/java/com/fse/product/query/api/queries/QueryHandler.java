package com.fse.product.query.api.queries;



import com.fse.cqrs.core.domain.BaseEntity;

import java.util.List;

public interface QueryHandler {

    List<BaseEntity> handle(FindProductByIdQuery query);

}
