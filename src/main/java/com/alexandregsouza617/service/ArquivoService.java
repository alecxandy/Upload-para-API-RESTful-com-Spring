package com.alexandregsouza617.service;

import com.alexandregsouza617.model.Arquivo;
import com.alexandregsouza617.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    public Arquivo save(Arquivo arquivo) {
        return arquivoRepository.save(arquivo);
    }

}
