package br.home.adrnmatos.persistence;

import java.util.List;

import br.home.adrnmatos.model.Cliente;

public interface ClienteDAO {
	
	public void makePersistent(Cliente cliente);
	
	public List<Cliente> listaClientes();
	
	public void excluirCliente(Cliente cliente);
	
	public void atualizarCliente(Cliente cliente);

}
