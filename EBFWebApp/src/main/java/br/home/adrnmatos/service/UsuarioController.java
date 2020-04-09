package br.home.adrnmatos.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.home.adrnmatos.domain.Usuario;
import br.home.adrnmatos.persistence.UsuarioDAO;
import br.home.adrnmatos.uteis.Uteis;

@Named(value = "usuarioController")
@RequestScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	Usuario usuario;
	
	@Inject
	UsuarioDAO usuarioDAO;
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String efetuarLogin() {

		if(StringUtils.isEmpty(usuario.getLogin()) || StringUtils.isBlank(usuario.getLogin())) {

			Uteis.Mensagem("Favor informar o login!");
			return null;
		} else if(StringUtils.isEmpty(usuario.getSenha()) || StringUtils.isBlank(usuario.getSenha())) {

			Uteis.Mensagem("Favor informara senha!");
			return null;
		} else {

			Usuario user = usuarioDAO.validarUsuario(usuario);

			if(user != null) {

				user.setSenha(null);
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", user);

				return "sistema/home?faces-redirect=true";

			} else {
				
				Uteis.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}
 
	}

	public void salvarUsuario() {
		
		usuarioDAO.makePersistent(usuario);
	}
}
