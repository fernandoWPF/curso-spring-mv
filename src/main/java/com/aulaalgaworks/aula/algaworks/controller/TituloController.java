package com.aulaalgaworks.aula.algaworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aulaalgaworks.aula.algaworks.model.StatusTitulo;
import com.aulaalgaworks.aula.algaworks.model.Titulo;
import com.aulaalgaworks.aula.algaworks.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired//IoC o Spring vai criar a instancia do objeto aqui. Muito loco.
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
		modelAndView.addObject("todosStatusTitulo", StatusTitulo.values());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView Salvar(Titulo titulo) {
		
		titulos.save(titulo);
		ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
		modelAndView.addObject("mensagem", "Título Salvo com Sucesso!");
		return modelAndView;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> statusTitulos(){
		return Arrays.asList(StatusTitulo.values());
		
	}
}
