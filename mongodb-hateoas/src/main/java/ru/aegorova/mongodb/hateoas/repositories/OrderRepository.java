package ru.aegorova.mongodb.hateoas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.aegorova.mongodb.hateoas.models.Order;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    @RestResource(path = "paid", rel = "paid")
    @Query(value = "{status: 'paid', $or: [{items: ?items}, {items_count: {$lt: ?1}}]}")
    List<Order> find(@Param("items") List<String> items, @Param("items_count") int maxItemsCount, Pageable pageable);
}
