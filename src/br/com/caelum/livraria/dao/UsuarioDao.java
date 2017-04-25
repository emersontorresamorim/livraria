package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario buscaPeloLogin(String login) {
		TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.login = :pLogin", Usuario.class);
		query.setParameter("pLogin", login);
		return query.getSingleResult();
	}
	
}
