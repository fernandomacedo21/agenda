package com.fernandomacedo.agenda.controller;


import com.fernandomacedo.agenda.model.Compromisso;
import com.fernandomacedo.agenda.model.exception.CompromissoInexistenteException;
import com.fernandomacedo.agenda.repository.CompromissoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {

    @Autowired
    CompromissoRepository repository;

    @PostMapping
    public Compromisso criarNovoCompromisso(@RequestBody Compromisso compromisso){
        return repository.save(compromisso);
    }

    @GetMapping
    public List<Compromisso> lista(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Compromisso atualizarCompromisso(@PathVariable long id,
                                            @RequestBody Compromisso compromissoRequest){

        Compromisso comprissoAtual = repository.findById(id).get();
        comprissoAtual.setData(compromissoRequest.getData());
        comprissoAtual.setTitulo(compromissoRequest.getTitulo());
        comprissoAtual.setHorarioInicio(compromissoRequest.getHorarioInicio());
        comprissoAtual.setHorarioFim(compromissoRequest.getHorarioFim());

        repository.save(comprissoAtual);

        return comprissoAtual;
    }


    @DeleteMapping("/{id}")
    public void excluirCompromisso(@PathVariable long id){
       if(repository.findById(id).isPresent()){
           repository.deleteById(id);
       }else{
           throw new CompromissoInexistenteException();
       }
    }
}
