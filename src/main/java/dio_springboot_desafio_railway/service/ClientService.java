package dio_springboot_desafio_railway.service;

import dio_springboot_desafio_railway.models.Client;

public interface ClientService {
    Client findById(Long id);
    Client create(Client client);
}
