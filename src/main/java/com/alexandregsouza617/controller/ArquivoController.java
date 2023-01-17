package com.alexandregsouza617.controller;

import com.alexandregsouza617.model.Arquivo;
import com.alexandregsouza617.service.ArquivoService;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;


@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping
    public ResponseEntity<Arquivo> test(@RequestParam("file") MultipartFile file)  {

        try {
            String codificadoBase64 = Base64.getEncoder().encodeToString(file.getBytes());
            Arquivo arquivo = new Arquivo();
            arquivo.setBase64(codificadoBase64);
            return ResponseEntity.status(HttpStatus.CREATED).body(arquivoService.save(arquivo));
        } catch (Exception ignored) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Arquivo());
        }


    }


    /*
        //descodificar
        byte[] arrayByte = Base64.getDecoder().decode(codificado);
        String textoString = new String(arrayByte);
*/

}
