@org.hibernate.annotations.GenericGenerator(
	name = "ID_GENERATOR",
	strategy = "enhanced-sequence",
	parameters = {
			@org.hibernate.annotations.Parameter(
				name = "sequence_name",
				value = "EBF_SEQUENCE"
			),
			@org.hibernate.annotations.Parameter(
				name = "initial-value",
				value = "1000"
			)
	})

@org.hibernate.annotations.NamedQueries({
	 
	@org.hibernate.annotations.NamedQuery(name = "Cliente.findAll",query= "SELECT c FROM Cliente c")
 
})

package br.home.adrnmatos.model;
