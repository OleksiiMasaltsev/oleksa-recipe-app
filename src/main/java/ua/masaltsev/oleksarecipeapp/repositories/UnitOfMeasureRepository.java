package ua.masaltsev.oleksarecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.oleksarecipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
