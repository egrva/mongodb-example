package ru.aegorova.mongodb.hateoas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.aegorova.mongodb.hateoas.models.Service;

public interface ServiceRepository extends PagingAndSortingRepository<Service, String> {
}
