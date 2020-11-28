package ru.aegorova.mongodb.example.jpa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aegorova.mongodb.example.jpa.models.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    @Query(value = "{status: 'paid', $or: [{items: ?0}, {items_count: {$lt: ?1}}]}")
    List<Order> find(@Param("items") List<String> items, @Param("items_count") int maxItemsCount);
}
