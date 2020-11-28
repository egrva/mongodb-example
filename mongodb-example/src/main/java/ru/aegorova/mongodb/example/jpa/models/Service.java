package ru.aegorova.mongodb.example.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "services")
public class Service {
    @Id
    private String _id;
    private String name;
    private Integer price;
}
