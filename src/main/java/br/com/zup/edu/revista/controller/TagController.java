package br.com.zup.edu.revista.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.revista.model.Tag;
import br.com.zup.edu.revista.repository.TagRepository;

@RestController
@RequestMapping("/tags")
public class TagController {
	
	private final TagRepository repository;
	
	public TagController(TagRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	ResponseEntity<Void> cadastrar(@RequestBody @Valid TagDTO request, UriComponentsBuilder uriComponentsBuilder){
		Tag tag = request.toModel();
		
		repository.save(tag);
		URI location = uriComponentsBuilder.path("/tags/{id}").buildAndExpand(tag.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
