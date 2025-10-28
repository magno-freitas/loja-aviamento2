package com.loja.lojaaviamento.repository;

import com.loja.lojaaviamento.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}