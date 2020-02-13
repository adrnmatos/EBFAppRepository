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


package br.home.adrnmatos.model;