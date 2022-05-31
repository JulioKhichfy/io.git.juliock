package io.git.juliock.service;

import io.git.juliock.model.Cliente;
import io.git.juliock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    //injeção de dependencia
    /*@Autowired*/
    private ClientRepository clientRepository;

    //injeção de dependencia por construtor.
    //outra maneira é no setRepository
    @Autowired //poderia omitir a anotação @Autowired pois ja esta anotado com @service
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public String salvarCliente(Cliente cliente){
        String result;
        if(validarCliente(cliente)){
            Cliente clienteSalvo = clientRepository.insertCliente(cliente);
            result = "ClientService.class - salvarCliente() - Cliente salvo " + clienteSalvo.getNome() + " salvo";
        } else {
            result = "ClientService.class - salvarCliente() - Erro ao salvar Cliente";
        }
        return result;

    }

    private boolean validarCliente(Cliente cliente){
        if(cliente != null && !cliente.getNome().isEmpty()){
            System.out.println("ClientService.class - validarCliente() true ");
            return true;
        }
        System.out.println("ClientService.class - validarCliente() false ");
        return false;
    }
}
