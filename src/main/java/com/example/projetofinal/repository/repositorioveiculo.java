package com.example.projetofinal.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.projetofinal.model.veiculo;

import org.springframework.stereotype.Component;

@Component
public class repositorioveiculo {
    
    private List<veiculo>veiculos;
    private int nextcode;

    @PostConstruct
    public void cadastroDeCarro(){  
        nextcode=1;    
        veiculos = new ArrayList<veiculo>();  
    }

    public veiculo save(veiculo veiculo){
        veiculo.setCodigo(nextcode++);
        veiculos.add(veiculo);
        return veiculo;
    }

    public void remove(veiculo veiculo){
        veiculos.remove(veiculo);
    }

    public List<veiculo>getAllVeiculos(){
        return veiculos;
    }

    public Optional<veiculo> getVeiculoByCodigo(int numero){
        for (veiculo veiculo : veiculos) {
            if (veiculo.getCodigo() == numero) {
                return Optional.of(veiculo);
            }
        }    
        return Optional.empty(); //return Escolas.stream().filter(e->e.getCodigo()==codigo).findFirst();  
    }


    public veiculo update(veiculo veiculo)
    {

        veiculo aux = getVeiculoByCodigo(veiculo.getCodigo()).get(); 

        if(aux != null){
            aux.setModelo(veiculo.getModelo());
            aux.setValor(veiculo.getValor());  
        }
        return aux;
    }

    
    
}
