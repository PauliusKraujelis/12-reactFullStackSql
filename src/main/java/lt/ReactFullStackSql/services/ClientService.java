package lt.ReactFullStackSql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ReactFullStackSql.entities.Client;
import lt.ReactFullStackSql.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findById(Long id) {
		return clientRepository.findById(id)
				.orElse(new Client() );
	}

	public Client getBoxById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client was not found by id: " + id));
    }
	
	public Client save(Client client) {

		return clientRepository.save(client);
	}

	public void deleteById(Long id) {

		clientRepository.deleteById(id);
		
	}
	
	
}
