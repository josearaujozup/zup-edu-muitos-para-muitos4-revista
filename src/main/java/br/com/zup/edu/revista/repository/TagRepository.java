package br.com.zup.edu.revista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.revista.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
