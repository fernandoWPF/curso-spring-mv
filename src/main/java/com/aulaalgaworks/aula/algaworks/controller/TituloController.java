package com.aulaalgaworks.aula.algaworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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

	@Autowired // IoC o Spring vai criar a instancia do objeto aqui. Muito loco.
	private Titulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
		modelAndView.addObject(new Titulo());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {

		ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
		if(errors.hasErrors()){
			return modelAndView;
		}
		titulos.save(titulo);
		modelAndView.addObject("mensagem", "Título Salvo com Sucesso!");
		return modelAndView;
	}

	@RequestMapping
	public ModelAndView pesquisar() {

		List<Titulo> titulos = this.titulos.findAll();
		ModelAndView modelAndView = new ModelAndView("PesquisaTitulo");
		modelAndView.addObject("titulos", titulos);
		return modelAndView;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> statusTitulos() {
		return Arrays.asList(StatusTitulo.values());
	}
}
