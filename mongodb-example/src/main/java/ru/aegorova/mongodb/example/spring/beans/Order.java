package ru.aegorova.mongodb.example.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private String _id;
    private Integer items_count;
    private String status;
    private List<String> items;
    private Boolean active;
    private Map<String, String> services;

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("items_count=" + items_count)
                .add("status=" + status)
                .add("items=" + items)
                .add("active=" + active)
                .add("services=" + services)
                .toString();
    }
}
