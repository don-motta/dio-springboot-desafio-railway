package dio_springboot_desafio_railway.controller;

import dio_springboot_desafio_railway.models.Client;
import dio_springboot_desafio_railway.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        var client = clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client clientToCreate){
        var clientCreated = clientService.create(clientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() // Cria a URI para o novo recurso
                .path("/{id}")
                .buildAndExpand(clientCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(clientCreated);  // Retorna o status 201 Created com o recurso criado no corpo da resposta
    }
}
