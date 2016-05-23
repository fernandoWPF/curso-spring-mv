package com.aulaalgaworks.aula.algaworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aulaalgaworks.aula.algaworks.model.StatusTitulo;
import com.aulaalgaworks.aula.algaworks.model.Titulo;
import com.aulaalgaworks.aula.algaworks.repository.Titulos;

@Service
public class CadastroTituloService {

	@Autowired
	private Titulos titulos;

	public void save(Titulo titulo) {

		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Informe a data de vencimento corretamente");
		}
	}

	public void delete(Long codigo) {

		titulos.delete(codigo);

	}
	
	public String receber(Long codigo){
		
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		
		return titulo.getStatus().getDescricao();
		
	}

}
