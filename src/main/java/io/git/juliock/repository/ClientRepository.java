package io.git.juliock.repository;

import io.git.juliock.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

    public Cliente insertCliente(Cliente cliente){
        System.out.println("ClientRepository.class - insertCliente() - Savando Cliente " + cliente.getNome());
        return cliente;
    }
}
