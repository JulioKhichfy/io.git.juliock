package com.umaoutrabiblioteca.projeto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UmaConfiguracaoExterna {

    @Bean(name = "outraConfiguracao")
    public String outraConfiguracao(){

        return "Sistema de Vendas!!";

    }
}
