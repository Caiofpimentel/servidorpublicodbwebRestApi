package com.caiofpimentel.servidorpublicodbwebRestApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiofpimentel.servidorpublicodbwebRestApi.entity.ServidorPublico;
import com.caiofpimentel.servidorpublicodbwebRestApi.repository.ServidorPublicoRepository;

@Service
public class ServidorPublicoServiceImpl implements ServidorPublicoService {

	@Autowired
	private ServidorPublicoRepository servidorRepository;
	
	@Override
	public List<ServidorPublico> findAll(){
		List<ServidorPublico> servidorespublicos = new ArrayList<>();
		servidorRepository.findAll().forEach(servidorespublicos::add);
		return servidorespublicos;	
	}

	@Override
	public Optional<ServidorPublico> findByMatricula(long matricula) {
	
		return servidorRepository.findById(matricula);
	}

	@Override
	public void save(ServidorPublico servidor) {
		
		servidorRepository.save(servidor);
	}

	@Override
	public void update(ServidorPublico servidorPublico) {
		
		Optional<ServidorPublico> servidorEncontrado = servidorRepository.findById(servidorPublico.getMatricula());
		servidorEncontrado.ifPresent(p -> {servidorRepository.save(servidorPublico);});
	}

	@Override
	public void delete(long matricula) {
		
		Optional<ServidorPublico> servidorEncontrado = servidorRepository.findById(matricula);
		servidorEncontrado.ifPresent(p -> {servidorRepository.delete(servidorEncontrado.get());});
	}

	

}
