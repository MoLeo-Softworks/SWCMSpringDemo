package com.moritzb.swcmspringdemo.service;

import com.moritzb.swcmspringdemo.domain.Person;
import com.moritzb.swcmspringdemo.persistence.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = false)
    public Person createPerson(@NotNull @Valid Person p) {
        return personRepository.save(p);
    }

    public List<Person> findPersonByLastNamePart(@NotEmpty String name) {
        return personRepository.findByLastName(name);
    }

}
