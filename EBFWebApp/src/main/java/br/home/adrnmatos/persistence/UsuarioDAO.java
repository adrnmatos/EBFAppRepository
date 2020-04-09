package br.home.adrnmatos.persistence;

import br.home.adrnmatos.domain.Usuario;

public interface UsuarioDAO {
	
	public void makePersistent(Usuario usuario);
	
	public Usuario validarUsuario(Usuario usuario);

}
