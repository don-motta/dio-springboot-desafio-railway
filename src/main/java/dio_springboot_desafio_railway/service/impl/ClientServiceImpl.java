package dio_springboot_desafio_railway.service.impl;

import dio_springboot_desafio_railway.models.Client;
import dio_springboot_desafio_railway.repository.UserRepository;
import dio_springboot_desafio_railway.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientServiceImpl implements ClientService {

    private final UserRepository userRepository;

    public ClientServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Client findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Client create(Client client) {
        if (client.getId() != null && userRepository.existsById(client.getId())){
            throw new IllegalArgumentException("Usuário já existe!");
        }
        return userRepository.save(client);
    }
}
