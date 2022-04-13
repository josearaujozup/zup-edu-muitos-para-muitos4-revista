package br.com.zup.edu.revista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.revista.model.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Long>{

}
