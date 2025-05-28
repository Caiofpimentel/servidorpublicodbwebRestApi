package com.caiofpimentel.servidorpublicodbwebRestApi.service;

import java.util.List;
import java.util.Optional;

import com.caiofpimentel.servidorpublicodbwebRestApi.entity.ServidorPublico;

public interface ServidorPublicoService  {

    List<ServidorPublico> findAll();  

    Optional<ServidorPublico> findByMatricula(long matricula);

    void save(ServidorPublico servidorPublico);
        
    void update(ServidorPublico servidorPublico);
    
    void delete(long matricula);

    

   
}