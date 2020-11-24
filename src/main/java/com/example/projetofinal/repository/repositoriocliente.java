package com.example.projetofinal.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.projetofinal.model.cliente;

import org.springframework.stereotype.Component;

@Component
public class repositoriocliente {

    private List<cliente>clientes;
    private int nextCode;


    @PostConstruct
    public void cadastrodeEscola(){
        nextCode=1;
        clientes = new ArrayList<cliente>();

    }

    public cliente save(cliente cliente) {
        cliente.setCodigo(nextCode++);
        clientes.add(cliente);
        return cliente;
    }

	public void remove(cliente cliente) {
        clientes.remove(cliente);
    }
    public List<cliente>getAllClientes(){
        return clientes;
    }
    public Optional<cliente> getEscolaByCodigo(int codigo){
        for (cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return Optional.of(cliente);
            }
        }    
        return Optional.empty(); //return Escolas.stream().filter(e->e.getCodigo()==codigo).findFirst();  
    }

    public cliente update(cliente cliente)
    {

        cliente aux = getEscolaByCodigo(cliente.getCodigo()).get(); 

        if(aux != null){
            aux.setNome(cliente.getNome());
            aux.setEnd(cliente.getEnd());
        }
        return aux;
    }
  
}
