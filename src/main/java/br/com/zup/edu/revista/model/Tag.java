package br.com.zup.edu.revista.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "tags")
    private Set<Revista> revistas = new HashSet<>();
	
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
	
	public void adicionar(Revista revista) {
        this.revistas.add(revista);
    }
}
