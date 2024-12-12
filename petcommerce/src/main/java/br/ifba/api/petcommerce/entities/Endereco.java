package br.ifba.api.petcommerce.entities;

import br.ifba.api.petcommerce.dtos.EnderecoDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    
	public Endereco() {
		super();
    }
	
	public Endereco(String rua, String numero, String cidade, String estado, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public Endereco(EnderecoDTO endereco) {
		this.rua = endereco.rua();
		this.numero = endereco.numero();
		this.cidade = endereco.cidade();
		this.estado = endereco.estado();
		this.cep = endereco.cep();
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
