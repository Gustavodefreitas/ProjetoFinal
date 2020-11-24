package com.example.projetofinal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.projetofinal.model.cliente;
import com.example.projetofinal.repository.repositoriocliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class clienteService {

    @Autowired
    private repositoriocliente repositorio;

    @Autowired 
    private veiculoService veiculoService;

    public List<cliente> getAllcliente(){
        return repositorio.getAllClientes();
    }
    public List<cliente> getAllClienteByCodigo(int codigo){

        List<cliente> clientes = repositorio.getAllClientes();
        List<cliente> clienteretorna = new ArrayList<cliente>();
        for(cliente cliente: clientes)
        {
            if(cliente.getCodigo()==codigo)
            {
                clienteretorna.add(cliente);
            }
        }
        return clienteretorna;
    }


    
    public cliente getclienteByCodigo(int numero) {
        Optional <cliente> op = repositorio.getEscolaByCodigo(numero);
		return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente nao cadastrado"));
    }

    
    
}
