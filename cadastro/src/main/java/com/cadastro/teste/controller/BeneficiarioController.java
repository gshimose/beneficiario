package com.cadastro.teste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.teste.model.Beneficiario;
import com.cadastro.teste.request.BeneficiarioPayload;
import com.cadastro.teste.service.BeneficiarioService;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
	
	 @Autowired
	 private BeneficiarioService beneficiarioService;
 
	    //Cadastrar um beneficiário junto com seus documentos &
	    //Atualizar os dados cadastrais de um beneficiário
	    @PostMapping("/gravar")
	    public String gravar(@RequestBody BeneficiarioPayload beneficiarioRequest) {
	        return beneficiarioService.salvar(beneficiarioRequest);
	    }
		
		//Listar todos os beneficiários cadastrados
		@GetMapping("/listar")
		public List<BeneficiarioPayload> listar ( ) {
	
			return beneficiarioService.listar();
		}
 
		
		//Listar todos os documentos de um beneficiário a partir de seu id
		@GetMapping("/listarbeneficiario/{id}")
		public BeneficiarioPayload listarbeneficiario (@PathVariable("id") Long id) {
	
			return beneficiarioService.listarBeneficiario(id);
		}	
		
		//Remover um beneficiário
		@DeleteMapping("/excluirbeneficiario/{id}")
		public String excluirbeneficiario (@PathVariable("id") Long id) {
	
			return beneficiarioService.excluirBeneficiario(id);
		}	


}