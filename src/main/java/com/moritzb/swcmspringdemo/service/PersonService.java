package com.moritzb.swcmspringdemo.service;

import com.moritzb.swcmspringdemo.persistence.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
