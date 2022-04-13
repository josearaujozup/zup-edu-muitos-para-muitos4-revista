package br.com.zup.edu.revista.controller;

import javax.validation.constraints.NotBlank;

import br.com.zup.edu.revista.model.Tag;

public class TagDTO {
	
	@NotBlank
	private String nome;
	
	public TagDTO(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public TagDTO() {
		
	}
	
	public Tag toModel() {
		return new Tag(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
}
