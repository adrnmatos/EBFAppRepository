package br.home.adrnmatos.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.home.adrnmatos.domain.Usuario;
import br.home.adrnmatos.uteis.Uteis;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void makePersistent(Usuario usuario) {

		EntityManager entityManager = Uteis.jpaEntityManager();
		
		entityManager.persist(usuario);
	}

	@Override
	public Usuario validarUsuario(Usuario usuario) {
		
		try {

			Query query = Uteis.jpaEntityManager().createNamedQuery("Usuario.findUser");
			query.setParameter("login", usuario.getLogin());
			query.setParameter("senha", usuario.getSenha());

			return (Usuario) query.getSingleResult();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
