package br.home.adrnmatos.business;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.home.adrnmatos.model.Cliente;
import br.home.adrnmatos.persistence.ClienteDAO;

@Named(value = "clienteController")
@RequestScoped
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	Cliente cliente;
	
	@Inject
	ClienteDAO clienteDAO;
	
	public void salvarCliente() {
	
		clienteDAO.makePersistent(cliente);
	}
	
	public List<Cliente> listarClientes() {
		
		return clienteDAO.listaClientes();
	}
	
	public void excluirCliente(Cliente cliente) {
		
		clienteDAO.excluirCliente(cliente);
	}
	
	public void editarCliente(Cliente cliente) {
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> sessionMapObj = ec.getSessionMap();
		
		sessionMapObj.put("editRecordObj", cliente);
		
		try {			
			ec.redirect(ec.getRequestContextPath()+"/sistema/editarCliente.xhtml");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarCliente(Cliente cliente) {
		
		clienteDAO.atualizarCliente(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
