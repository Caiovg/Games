package com.caio.games.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@NotBlank(message = "Informe seu nome")
	private String nome;
	@NotBlank(message = "Informe seu email") 
	@Email
	//para deixar a tabela no banco como unique @Column(unique=true)
	private String email;
	
	@NotBlank(message = "Informe seu userName") 
	private String usuario;
	
	@NotBlank(message = "Informe sua senha")
	@Size(min = 5)
	private String senha;
	
	
	public Usuario(Integer idUsuario, String nome, String email, String usuario, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
