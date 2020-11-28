package ru.aegorova.mongodb.example.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.StringJoiner;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {

    private String _id;
    private String name;
    private Integer price;

    public Service(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Service.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("name='" + name + "'")
                .add("price='" + price + "'")
                .toString();
    }
}
