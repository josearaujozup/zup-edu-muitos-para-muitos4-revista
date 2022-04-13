package br.com.zup.edu.revista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	
	
	public Tag(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Tag() {
		
	}
	
	public Long getId() {
		return id;
	}
	
}
