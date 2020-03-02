package br.home.adrnmatos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;
	
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String telefone;
	
	private Set<Endereco> enderecos = new HashSet<>();

	private Set<Plano> planList = new HashSet<>();


	public Client() {
		
	}
	
	public Client(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Plano> getPlanList() {
		return planList;
	}

	public void setPlanList(Set<Plano> planList) {
		this.planList = planList;
	}

	public boolean isActive() {

		if(planList.isEmpty()) return false;

		if(getActivePlan() == null) return false;

		return true;
		
	}

	public void assignPlan(Plano p) {
	
		this.planList.add(p);
	}

	public Plano getActivePlan() {
	
		return null;
		
	}
	  
}