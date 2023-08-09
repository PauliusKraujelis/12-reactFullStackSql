package lt.ReactFullStackSql.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.ReactFullStackSql.entities.Client;
import lt.ReactFullStackSql.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientsController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public List<Client> getClient() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public Client getClient(@PathVariable Long id) {
		return clientService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client) throws URISyntaxException {
		Client savedClient = clientService.save(client);
		return ResponseEntity
				.created(new URI("/clients/" + savedClient.getId()))
				.body(savedClient);
	}
	
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client currentClient = clientService.findById(id);
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient = clientService.save(client);

        return ResponseEntity.ok(currentClient);
    }
}
