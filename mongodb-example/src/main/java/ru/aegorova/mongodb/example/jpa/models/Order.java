package ru.aegorova.mongodb.example.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "orders")
@Builder
public class Order {
    @Id
    private String _id;
    private Integer items_count;
    private String status;
    private List<String> items;
    private Boolean active;
    @DBRef
    private List< Service> services;
}
