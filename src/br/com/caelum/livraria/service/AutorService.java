package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao dao;
	
	public void adiciona(Autor autor) {
		dao.salva(autor);
		
		// simulação de uma falha de validação em uma regra de negócio
		// throw new LivrariaException();
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}
}
