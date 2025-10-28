package com.loja.lojaaviamento.service;

import com.loja.lojaaviamento.model.Person;
import com.loja.lojaaviamento.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> listAll() {
        return repository.findAll();
    }

    public void save(Person person) {
        repository.save(person);
    }

    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}