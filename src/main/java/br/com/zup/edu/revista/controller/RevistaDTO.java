package br.com.zup.edu.revista.controller;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.edu.revista.model.Revista;
import br.com.zup.edu.revista.model.Tag;
import br.com.zup.edu.revista.repository.TagRepository;

public class RevistaDTO {
	
	@NotBlank
	@Size(max = 120)
	private String titulo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	
	@NotEmpty
    @Size(min = 1)
    private Set<Long> tagsIds;

	public RevistaDTO(@NotBlank String titulo, @NotNull LocalDate dataPublicacao,
			@NotEmpty @Size(min = 1) Set<Long> tagsIds) {
		
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.tagsIds = tagsIds;
	}
	
	public RevistaDTO() {
		
	}
	
	public Revista toModel(TagRepository tagRepository) {
        Set<Tag> tags = this.tagsIds.stream()
                .map(idTag -> tagRepository.findById(idTag).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zupper não cadastrado")))
                .collect(Collectors.toSet());
        
        Revista revista = new Revista(titulo, dataPublicacao,tags);
    
        return revista;
    }

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Set<Long> getTagsIds() {
		return tagsIds;
	}

}
