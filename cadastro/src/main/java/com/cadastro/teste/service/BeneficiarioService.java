package com.cadastro.teste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.teste.model.Beneficiario;
import com.cadastro.teste.model.Documento;
import com.cadastro.teste.repository.BeneficiarioRepository;
import com.cadastro.teste.repository.DocumentoRepository;
import com.cadastro.teste.request.BeneficiarioPayload;

@Service
public class BeneficiarioService {
	
	@Autowired
	BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	DocumentoRepository documentoRepository;
	
	
	public String salvar (BeneficiarioPayload beneficiarioRequest) {
		
		String resultado = "Gravado com sucesso!";
		
		try {
				Beneficiario beneficiario = new Beneficiario();
				
				beneficiario.setId(beneficiarioRequest.getId());
				beneficiario.setNome(beneficiarioRequest.getNome());
				beneficiario.setTelefone(beneficiarioRequest.getTelefone());
				beneficiario.setDataNascimento(beneficiarioRequest.getDataNascimento());
				beneficiario.setDataInclusao(beneficiarioRequest.getDataInclusao());
				beneficiario.setDataAtualizacao(beneficiarioRequest.getDataAtualizacao());
				
				beneficiarioRepository.save(beneficiario);
				
				for (int i=0; i < beneficiarioRequest.getDocumentos().size(); i++ ) {
					Documento  documento = new Documento();
					documento.setId(beneficiarioRequest.getDocumentos().get(i).getId());
					documento.setTipoDocumento(beneficiarioRequest.getDocumentos().get(i).getTipoDocumento());
					documento.setIdBeneficiario(beneficiarioRequest.getDocumentos().get(i).getIdBeneficiario());
					documento.setDescricao(beneficiarioRequest.getDocumentos().get(i).getDescricao());
					documento.setDataInclusao(beneficiarioRequest.getDocumentos().get(i).getDataInclusao());
					documento.setDataAtualizacao(beneficiarioRequest.getDocumentos().get(i).getDataAtualizacao());
					
					documentoRepository.save(documento);
				}
		} catch (Exception e) {
			resultado = "[ERRO] - " + e.getMessage();
		}		

		return resultado;
	}
	
	
	public List<BeneficiarioPayload> listar () {
 
		List<BeneficiarioPayload> beneficiariosPayload = new ArrayList<BeneficiarioPayload>();
		List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
		
		beneficiarios = beneficiarioRepository.findAll();
		
		for (int i=0; i < beneficiarios.size(); i++ ) {
			BeneficiarioPayload beneficiarioPayload = new BeneficiarioPayload();
			beneficiarioPayload.setId(beneficiarios.get(i).getId());
			beneficiarioPayload.setNome(beneficiarios.get(i).getNome());
			beneficiarioPayload.setTelefone(beneficiarios.get(i).getTelefone());
			beneficiarioPayload.setDataInclusao(beneficiarios.get(i).getDataInclusao());
			beneficiarioPayload.setDataNascimento(beneficiarios.get(i).getDataNascimento());
			beneficiarioPayload.setDataAtualizacao(beneficiarios.get(i).getDataAtualizacao());
			
			List<Documento> documentos = documentoRepository.findByIdBeneficiario(beneficiarios.get(i).getId());
			beneficiarioPayload.setDocumentos(documentos);
			beneficiariosPayload.add(beneficiarioPayload);
	
		}
		
		return beneficiariosPayload;
	}
	
	
	public  BeneficiarioPayload listarBeneficiario (Long id) {

		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);

			BeneficiarioPayload beneficiarioPayload = new BeneficiarioPayload();
			beneficiarioPayload.setId(beneficiario.get().getId());
			beneficiarioPayload.setNome(beneficiario.get().getNome());
			beneficiarioPayload.setTelefone(beneficiario.get().getTelefone());
			beneficiarioPayload.setDataInclusao(beneficiario.get().getDataInclusao());
			beneficiarioPayload.setDataNascimento(beneficiario.get().getDataNascimento());
			beneficiarioPayload.setDataAtualizacao(beneficiario.get().getDataAtualizacao());
			
			List<Documento> documentos = documentoRepository.findByIdBeneficiario(beneficiario.get().getId());
			beneficiarioPayload.setDocumentos(documentos);

		
		return beneficiarioPayload;
		
		
		
	}
	
	public  String excluirBeneficiario (Long id) {
		String resultado = "Beneficiario excluido com sucesso!";
		try {
			//documentoRepository.deleteByIdBeneficiario(id);
			beneficiarioRepository.deleteById(id);
		} catch (Exception e) {
			resultado = "[ERRO] - " + e.getMessage();
		}
		return resultado;
		
	}
}
