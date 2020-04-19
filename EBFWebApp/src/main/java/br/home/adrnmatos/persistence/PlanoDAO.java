package br.home.adrnmatos.persistence;

import java.util.List;

import br.home.adrnmatos.domain.Plano;

public interface PlanoDAO {
	
	public void makePersistent(Plano plano);
	
	public List<Plano> getPlanos();
	
	public Plano findById(Long id);

}
