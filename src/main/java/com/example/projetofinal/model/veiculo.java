package com.example.projetofinal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class veiculo {

    private int codigo;
    private int valor;
    private String modelo;

    @JsonIgnore
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	

    

    
    
 
}
