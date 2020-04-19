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
	
	@org.hibernate.annotations.NamedQuery(name = "Cliente.findAll",query = "SELECT c FROM Cliente c"),
	@org.hibernate.annotations.NamedQuery(name = "Plano.findAll", query = "SELECT p FROM Plano p"),
	@org.hibernate.annotations.NamedQuery(name = "Usuario.findUser",
											query = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha"),
	@org.hibernate.annotations.NamedQuery(name = "Plano.findPlano", query = "SELECT p FROM Plano p WHERE p.id = : id"),
	@org.hibernate.annotations.NamedQuery(name = "Cliente.findCliente", query = "SELECT c FROM Cliente c WHERE c.id = : id"),
	@org.hibernate.annotations.NamedQuery(name = "Usuario.findUsuario", query = "SELECT u FROM Usuario u WHERE u.id = : id")
})

package br.home.adrnmatos.domain;
