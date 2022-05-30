package io.git.juliock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Podemos dar os nomes dependendo da config, exemplos:
 * config para web: WebConfiguration
 * config para segurança: SecurityConfiguration
 * config para BD: DataConfiguration
 */

//Essa classe passa a ser scaneada pelo springboot
@Configuration
public class MinhaConfiguration {

    //Configuração realizada através de 'Beans'
    //serão registrados os Beans

    /**
     * Criar esse Bean no contexto da aplicação para utilizar onde precisar
     * exemplo: poderiamos fazer uma conf para base de dados. conf de email e etc...
     * @return
     */
    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @Bean(name = "outraConfiguracao")
    public String outraConfiguracao(){
        return "Sistema de Vendas!!";
    }


}
