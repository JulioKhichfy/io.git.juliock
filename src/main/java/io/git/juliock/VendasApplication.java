//Todos os pacotes daqui pra frente passam a ser gerenciados/scaneados
//ou utilizar @ComponentScan(...).
// Por padrão tudo passa a ser gerenciado a patir desse pacote
package io.git.juliock;

import io.git.juliock.model.Cliente;
import io.git.juliock.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Adicionar a anotação @SpringBootApplication: reconhece que essa classe
//irá inicializar uma aplicação springboot


@ComponentScan(
        basePackages = {
        "io.git.juliock",
        "io.git.juliock.repository",
        "io.git.juliock.service",
        "com.umaoutrabiblioteca.projeto" // esse precisa, os outros já estao scaneados por padrão
    })

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
    private ClientService clienteService;

    @Autowired
    @Qualifier("outraConfiguracao")
    private String outraConfiguracao;

    //maneira de injetar diretamente a partir do properties
    @Value("${application.name}")
    private String applicationNameFromProperties;

    @GetMapping("/")
    public String raiz(){
        System.out.println("*** VendasApplication.class - Método raiz()");
        return "raiz";
    }

    //https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html
    @GetMapping("/nameFromProperties")
    public String nameFromProperties(){
        System.out.println("*** VendasApplication.class - Método nameFromProperties()");
        return applicationNameFromProperties;
    }

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

    @GetMapping("/salvar-cliente")
    public String salvarCliente(){
        System.out.println("*** VendasApplication.class - Método salvarCliente()");
        Cliente cliente = new Cliente();
        cliente.setNome("Julio Cesar Khichfy");
        String result = clienteService.salvarCliente(cliente);
        return result;
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
