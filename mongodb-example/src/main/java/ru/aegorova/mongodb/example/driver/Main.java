package ru.aegorova.mongodb.example.driver;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Projections.*;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("store");
        MongoCollection<Document> collection = database.getCollection("orders");

        Document searchQuery = new Document();

        searchQuery
                .append("status", "paid")
                .append("$or", Arrays.asList(
                        new Document("items", "apple"),
                        new Document("items_count", new Document("$lt", 3))));

        FindIterable<Document> resultDocuments = collection.find(searchQuery)
                .projection(fields(include("status", "items", "items_count"), excludeId()));

        for (Document document : resultDocuments) {
            System.out.println(document.toJson());
        }
    }
}
