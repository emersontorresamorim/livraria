package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // defini explicitamente que as transações são controladas pelo Container EJB (CMT)
public class AutorDao {

	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED) // o JTA garante que haverá uma transação rodando quando este método for executado, e caso não tenha nenhuma na hora que ocorre a chamada a transação é criada
	//@TransactionAttribute(TransactionAttributeType.MANDATORY) // exige que já exista a transação, obrigando quem faz a chamada a garantir que a transação exista ou seja criada
	public void salva(Autor autor) {
		em.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return em.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return em.find(Autor.class, autorId);
	}
	
}
