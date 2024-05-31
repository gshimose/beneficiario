package com.cadastro.teste.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.teste.model.Documento;


public interface DocumentoRepository extends JpaRepository<Documento, Long>{

	
	Optional<Documento> findById (Long Id);
	
	List<Documento> findByIdBeneficiario (Long IdBeneficiario);
	
	//void deleteByIdBeneficiario (Long IdBeneficiario);


}
