package ru.aegorova.mongodb.example.jpa.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.aegorova.mongodb.example.jpa.models.Service;

public interface ServiceRepository extends PagingAndSortingRepository<Service, String> {
}
