package com.julio.doctoroffice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julio.doctoroffice.domain.Pessoa;

public interface  PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
