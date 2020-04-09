package br.home.adrnmatos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.home.adrnmatos.domain.Cliente;
import br.home.adrnmatos.domain.Plano;
import br.home.adrnmatos.domain.Usuario;
import br.home.adrnmatos.domain.Venda;
import br.home.adrnmatos.persistence.PlanoDAO;
import br.home.adrnmatos.persistence.VendaDAO;

@Named(value = "vendaController")
@RequestScoped
public class VendaController {
	
	@Inject
	VendaDAO vendaDAO;
	
	@Inject
	PlanoDAO planoDAO;
	
	protected Cliente cliente;
	
	protected Plano plano;
	protected Map<String,String> planos = new HashMap<String, String>();
	protected String planoNome; 
	
	public String getPlanoNome() {
		return planoNome;
	}

	public void setPlanoNome(String planoNome) {
		this.planoNome = planoNome;
	}

	protected Usuario usuario;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Map<String, String> getPlanos() {
		return planos;
	}

	public void salvarVenda() {
		
		System.out.println(planoNome);
		
		Venda venda = new Venda(cliente, plano, usuario);
		
		vendaDAO.makePersistent(venda);
	}
	
	@PostConstruct
	public void init() {
		
		List<Plano> planosLista = planoDAO.getPlanos();
		
		for (Plano plano : planosLista) {
			planos.put(plano.getNome(), plano.getNome());
		}	
	}

}
