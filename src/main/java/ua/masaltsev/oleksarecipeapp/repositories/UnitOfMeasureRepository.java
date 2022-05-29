package ua.masaltsev.oleksarecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.oleksarecipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
