package io.git.juliock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Adicionar a anotação @SpringBootApplication: reconhece que essa classe
//irá inicializar uma aplicação springboot
@SpringBootApplication

//Basicamente informo que essa classe será um controlador rest
//podemos mandar mensagens do browser através dessa classe
@RestController
public class VendasApplication {

    //Identificar que queremos que o springboot injete
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @Autowired
    @Qualifier("outraConfiguracao")
    private String outraConfiguracao;

    //Irá subir o Tomcat: initialized with port(s): 8080 (http)
    //browser: http://localhost:8080/hello
    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println("*** VendasApplication.class - Método helloWorld()");
        return "Hello world";
    }

    @GetMapping("/helloApplicationName")
    public String helloApplicationName(){
        System.out.println("*** VendasApplication.class - Método helloApplicationName()");
        return applicationName;
    }

    @GetMapping("/helloOutraConfiguracao")
    public String helloOutraConfiguracao(){
        System.out.println("*** VendasApplication.class - Método helloOutraConfiguracao()");
        return outraConfiguracao;
    }

    //Dica: digitar 'psvm' cria a classe main
    public static void main(String[] args) {
        /**
         * comando que inicializa a aplicação springboot
         * param: VendasApplication.class
         * param: args
         */
        System.out.println("INICIALIZANDO A APLICAÇÃO SPRINGBOOT VENDASAPPLICATION");
        SpringApplication.run(VendasApplication.class, args);
    }
}
