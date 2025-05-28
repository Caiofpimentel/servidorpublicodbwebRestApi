package com.caiofpimentel.servidorpublicodbwebRestApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caiofpimentel.servidorpublicodbwebRestApi.entity.ServidorPublico;


@Repository
public interface ServidorPublicoRepository extends CrudRepository<ServidorPublico, Long> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário

}
