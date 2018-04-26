package br.com.itau.restbd.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entidade Cliente
 * @author Leonardo Oliveira
 *
 */
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = -8876290139533899937L;
	
	/**
	 * Sequence para gerar o ID inicia no 16 pois ao realizar o start da 
	 * aplicacao eu ja realizo o insert de 15 clientes para demo
	 */
	@Id
	@SequenceGenerator(name="clienteSequence", allocationSize=1, initialValue=16)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clienteSequence")
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	
	//Construtor com parametros
	public Cliente(Long id, String nome, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	//Construtor vazio
	public Cliente() {
		super();
	}

	/**
	 * Getters and Setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
