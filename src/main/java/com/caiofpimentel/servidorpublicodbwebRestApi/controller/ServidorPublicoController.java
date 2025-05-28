package com.caiofpimentel.servidorpublicodbwebRestApi.controller;




import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.caiofpimentel.servidorpublicodbwebRestApi.api.ServidorPublicoApiRest;
import com.caiofpimentel.servidorpublicodbwebRestApi.entity.ServidorPublico;
import com.caiofpimentel.servidorpublicodbwebRestApi.service.ServidorPublicoService;



@RestController
public class ServidorPublicoController implements ServidorPublicoApiRest {

    private ServidorPublicoService servidorService;
	
	@Autowired
	public void setServidorPublicoService(ServidorPublicoService servidorService)
	{
		this.servidorService = servidorService;
	}

    @GetMapping("/listarServidores")
    public ResponseEntity<List<ServidorPublico>> listarServidores() {
        List<ServidorPublico> servidorespublicos = servidorService.findAll();
        return new ResponseEntity<List<ServidorPublico>>(servidorespublicos, HttpStatus.OK);
    }

    @GetMapping("/listarServidor/{matricula}")
    public ResponseEntity<ServidorPublico> listarServidor(long matricula) {
       Optional<ServidorPublico> servidorEncontrado = servidorService.findByMatricula(matricula);
       if (servidorEncontrado.isPresent()) {
           return new ResponseEntity<ServidorPublico>(servidorEncontrado.get(), HttpStatus.OK);
       } else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Servidor não encontrado");
       }
    }

   

    @DeleteMapping("excluirServidor/{matricula}")
    public Void excluirServidor(long matricula) {
        Optional<ServidorPublico> servidorEncontrado = servidorService.findByMatricula(matricula);
        if (servidorEncontrado.isPresent()) {
            servidorService.delete(servidorEncontrado.get().getMatricula());
            throw new ResponseStatusException(HttpStatus.OK, "Servidor Publico deletado."); 
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Servidor não encontrado");
        }
    }

    @PutMapping("/editarServidor/{matricula}")
    public String editarServidor(long matricula, ServidorPublico servidor) {
       Optional<ServidorPublico> servidorEncontrado = servidorService.findByMatricula(matricula);
        if (servidorEncontrado.isPresent()) {
            servidorService.update(servidor);
            throw new ResponseStatusException(HttpStatus.OK, "Servidor Publico Atualizado."); 
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Servidor não encontrado");
        }
    }
  

    @PostMapping("/cadastrarServidor")
    public String cadastrarServidor(ServidorPublico novoServidor) {
        Optional<ServidorPublico> servidorExistente = servidorService.findByMatricula(novoServidor.getMatricula());
        if (servidorExistente.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Servidor já cadastrado com esta matrícula.");
        } else {
            servidorService.save(novoServidor);
            throw new ResponseStatusException(HttpStatus.CREATED, "Servidor Publico cadastrado com sucesso.");
        }
    }


    @ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleNotFoundException(ResponseStatusException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getReason());
		body.put("status", ex.getStatusCode());
		return new ResponseEntity<>(body, ex.getStatusCode());
	} 
    

    

}
