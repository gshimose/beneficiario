package com.cadastro.teste.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbbenef")
public class Beneficiario {
	
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
   
    @Column(name = "telefone", length = 50, nullable = false)
    private String telefone;
    
    @Column(name = "dataNascimento", length = 50, nullable = false)
    private String dataNascimento;
    
    @Column(name = "dataInclusao", length = 50, nullable = false)
    private String dataInclusao;
    
    @Column(name = "dataAtualizacao", length = 50, nullable = false)
    private String dataAtualizacao;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

//	public List<Documento> getDocumentos() {
//		return documentos;
//	}
//
//	public void setDocumentos(List<Documento> documentos) {
//		this.documentos = documentos;
//	}




    
    
    
    
}
