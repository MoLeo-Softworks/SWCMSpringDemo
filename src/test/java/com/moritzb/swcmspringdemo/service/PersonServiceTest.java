package com.moritzb.swcmspringdemo.service;

import com.moritzb.swcmspringdemo.domain.Person;
import com.moritzb.swcmspringdemo.persistence.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock private DateTimeFactory dateTimeFactory;
    @Mock private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setup() {
        assumeThat(dateTimeFactory).isNotNull();
        personService = new PersonService(personRepository, dateTimeFactory);
    }

    @Test
    void ensureCreatePerson() {
        when(dateTimeFactory.now()).thenReturn(LocalDateTime.of(2000, 1, 1, 0, 0));
        Person p = Person.builder().firstName("Max").lastName("Muster").build();
        personService.createPerson(p);
    }
}
