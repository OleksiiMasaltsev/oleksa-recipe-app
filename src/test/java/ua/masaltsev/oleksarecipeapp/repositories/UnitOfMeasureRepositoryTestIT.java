package ua.masaltsev.oleksarecipeapp.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.masaltsev.oleksarecipeapp.domain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTestIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    void findByDescription_teaspoon_true() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
        optionalUnitOfMeasure.ifPresent(unitOfMeasure -> assertEquals("Teaspoon", unitOfMeasure.getDescription()));
    }

    @Test
    void findByDescription_cup_true() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");
        optionalUnitOfMeasure.ifPresent(unitOfMeasure -> assertEquals("Cup", unitOfMeasure.getDescription()));
    }
}