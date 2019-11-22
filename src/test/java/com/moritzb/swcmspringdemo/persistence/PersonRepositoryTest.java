package com.moritzb.swcmspringdemo.persistence;

import com.moritzb.swcmspringdemo.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void ensureSaveAndReadWorksProperly() {
        Person p = Person.builder().firstName("Moritz").lastName("Brandstaetter").build();

        var saved = personRepository.save(p);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull().isPositive();
        assertThat(saved.getVersion()).isNotNull();
    }
}
