package br.com.gerenciamentoDeUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciamentoDeUsuarios.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}