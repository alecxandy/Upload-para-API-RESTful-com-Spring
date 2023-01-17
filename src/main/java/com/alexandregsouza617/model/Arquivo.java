package com.alexandregsouza617.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Lob
    private String base64;

}
