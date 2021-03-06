package br.home.adrnmatos.persistence;

import java.util.List;

import br.home.adrnmatos.domain.Cliente;

public interface ClienteDAO {
	
	public void makePersistent(Cliente cliente);
	
	public List<Cliente> listaClientes();
	
	public Cliente findById(Long clienteId);
	
	public void excluirCliente(Cliente cliente);
	
	public void atualizarCliente(Cliente cliente);

}
