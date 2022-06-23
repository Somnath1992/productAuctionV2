package com.fse.cqrs.core.infrastructure;



import com.fse.cqrs.core.domain.BaseEntity;
import com.fse.cqrs.core.queries.BaseQuery;
import com.fse.cqrs.core.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery query);
}
