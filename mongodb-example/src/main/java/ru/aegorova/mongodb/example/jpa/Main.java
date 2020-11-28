package ru.aegorova.mongodb.example.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aegorova.mongodb.example.jpa.configs.RepositoriesConfig;
import ru.aegorova.mongodb.example.jpa.models.Order;
import ru.aegorova.mongodb.example.jpa.models.Service;
import ru.aegorova.mongodb.example.jpa.repositories.OrderRepository;
import ru.aegorova.mongodb.example.jpa.repositories.ServiceRepository;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoriesConfig.class);
        OrderRepository orderRepository = context.getBean(OrderRepository.class);
        ServiceRepository serviceRepository = context.getBean(ServiceRepository.class);
//
//        Service delivery = Service.builder()
//                .name("delivery")
//                .price(300)
//                .build();
//
//        Service fitting = Service.builder()
//                .name("fitting")
//                .price(500)
//                .build();
//
//        serviceRepository.save(delivery);
//        serviceRepository.save(fitting);
//
//        String orderId = "5fc208c7dd65e11b82073123";
//
//        Order order = orderRepository.findById(orderId).orElseThrow(
//                () -> new IllegalArgumentException("Can't find order by id: " + orderId)
//        );
//
//        List<Service> services = Arrays.asList(fitting, delivery);
//        order.setServices(services);
//        orderRepository.save(order);

        System.out.println(orderRepository.find(Arrays.asList("apple"), 3 ));
    }
}

