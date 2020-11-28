package ru.aegorova.mongodb.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import ru.aegorova.mongodb.example.spring.beans.Order;
import ru.aegorova.mongodb.example.spring.beans.Service;
import ru.aegorova.mongodb.example.spring.configs.SimpleMongoConfig;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleMongoConfig.class);
        MongoTemplate template = context.getBean(MongoTemplate.class);
        Service service = new Service("loading", 1000);
        template.save(service, "new_service");

        List<Order> orders = template.find(new Query(
                where("active").is(true)
                        .orOperator(where("items").is("apple"),
                                where("items_count").lt(35))), Order.class, "orders");
        System.out.println(orders);

    }
}
