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
import br.home.adrnmatos.persistence.ClienteDAO;
import br.home.adrnmatos.persistence.PlanoDAO;
import br.home.adrnmatos.persistence.UsuarioDAO;
import br.home.adrnmatos.persistence.VendaDAO;
import br.home.adrnmatos.uteis.Uteis;

@Named(value = "vendaController")
@RequestScoped
public class VendaController {
	
	@Inject
	VendaDAO vendaDAO;
	
	@Inject
	PlanoDAO planoDAO;
	
	@Inject
	UsuarioDAO usuarioDAO;
	
	@Inject
	ClienteDAO clienteDAO;
	
	protected Cliente cliente;
	
	protected Long planoId;
	protected Map<String,Long> planos = new HashMap<String, Long>();
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getPlanoId() {
		return planoId;
	}

	public void setPlanoId(Long planoId) {
		this.planoId = planoId;
	}

	public Map<String, Long> getPlanos() {
		return planos;
	}

	public void salvarVenda() {
		
		Cliente cliente = clienteDAO.findById(2L);
		
		Plano plano = planoDAO.findById(planoId);
		
		Usuario usuario = usuarioDAO.findById(Uteis.getUsuarioAutenticado());
		
		Venda venda = new Venda(cliente, plano, usuario);
		
		vendaDAO.makePersistent(venda);
	}
	
	@PostConstruct
	public void init() {
		
		List<Plano> planosLista = planoDAO.getPlanos();
		
		for (Plano plano : planosLista) {
			planos.put(plano.getNome(), plano.getId());
		}	
	}

}
