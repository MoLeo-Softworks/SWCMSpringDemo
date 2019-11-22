package com.moritzb.swcmspringdemo.service;

import com.moritzb.swcmspringdemo.aspect.LogExecutionTime;
import com.moritzb.swcmspringdemo.domain.Person;
import com.moritzb.swcmspringdemo.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;
    private final DateTimeFactory dateTimeFactory;

    @LogExecutionTime
    @Transactional(readOnly = false)
    public Person createPerson(@NotNull @Valid Person p) {
        log.info("Create person at {}", dateTimeFactory.now());
        return personRepository.save(p);
    }

    public List<Person> findPersonByLastNamePart(@NotEmpty String name) {
        return personRepository.findByLastName(name);
    }

}
