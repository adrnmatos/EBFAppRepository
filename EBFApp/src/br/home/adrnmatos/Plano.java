package br.home.adrnmatos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Plano {
	
	private int id;
	private String nome;
	private int valor;
	private int numDias;
	private List<Interval> intervalList = new ArrayList<Interval>();
	
	public Plano() {

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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}

	public List<Interval> getIntervalList() {
		return intervalList;
	}

	public void setIntervalList(List<Interval> intervalList) {
		this.intervalList = intervalList;
	}

	public class Interval {
		
		private LocalTime intervalInit;
		private LocalTime intervalEnd;
		
		public Interval(LocalTime init, LocalTime end) {
			this.intervalInit = init;
			this.intervalEnd = end;
		}

		public LocalTime getIntervalInit() {
			return this.intervalInit;
		}

		public LocalTime getIntervalEnd() {
			return this.intervalEnd;
		}		
	}
	
	
	

}
