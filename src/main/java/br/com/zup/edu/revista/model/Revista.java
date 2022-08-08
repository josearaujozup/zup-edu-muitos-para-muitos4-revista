package br.com.zup.edu.revista.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Revista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
		
	@Column(nullable = false)
	private LocalDate dataPublicacao;
	
	@Column(nullable = false)
    @Size(min = 1)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "revista_tag", joinColumns = @JoinColumn(name = "revista_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

	public Revista(String titulo, LocalDate dataPublicacao, Set<Tag> tags) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.tags = tags;
	}
	
	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Revista() {
		
	}

	public Long getId() {
		return id;
	}
	
	public void adicionar(Set<Tag> novasTags){

        this.tags.addAll(novasTags);

        novasTags.forEach(tag-> tag.adicionar(this));
    }
	
}
