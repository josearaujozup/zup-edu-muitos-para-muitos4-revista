package br.com.zup.edu.revista.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.revista.model.Revista;
import br.com.zup.edu.revista.repository.RevistaRepository;
import br.com.zup.edu.revista.repository.TagRepository;

@RestController
@RequestMapping("/revistas")
public class RevistaController {
	
	private final TagRepository tagRepository;
	private final RevistaRepository repository;
	
	public RevistaController(TagRepository tagRepository, RevistaRepository repository) {
		this.tagRepository = tagRepository;
		this.repository = repository;
	}
	
	@PostMapping
	ResponseEntity<Void> cadastrar(@RequestBody @Valid RevistaDTO request,UriComponentsBuilder uriComponentsBuilder){
		
		Revista revista = request.toModel(tagRepository);
		
		repository.save(revista);
		URI location = uriComponentsBuilder.path("/revistas/{id}").buildAndExpand(revista.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
