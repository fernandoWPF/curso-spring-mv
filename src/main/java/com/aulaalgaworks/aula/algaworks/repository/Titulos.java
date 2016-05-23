package com.aulaalgaworks.aula.algaworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaalgaworks.aula.algaworks.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{
	
	public List<Titulo> findByDescricaoContaining(String descricao);

}
