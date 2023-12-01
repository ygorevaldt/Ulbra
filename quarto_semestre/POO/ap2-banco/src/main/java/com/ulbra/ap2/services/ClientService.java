package com.ulbra.ap2.services;

import com.ulbra.ap2.controllers.dto.ClientResponseDTO;
import com.ulbra.ap2.entities.Client;
import com.ulbra.ap2.repositories.ClientRepository;
import com.ulbra.ap2.services.utils.exeptions.NoRegisteredClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {
    private ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void create(Client client) {
        client.setId(UUID.randomUUID());
        this.repository.save(client);
    }

    public List<ClientResponseDTO> list() {
        try {
            Iterable<Client> clients = this.repository.findAll();
            Iterator<Client> iterator = clients.iterator();
            if (!iterator.hasNext()) {
                throw new NoRegisteredClients("Nenhum cliente cadastrado");
            }

            List<ClientResponseDTO> clientsResponse = new ArrayList<>();
            for (Client client : clients) {
                ClientResponseDTO dto = new ClientResponseDTO(client.getNome(), client.getIdade(), client.getProfissao());
                clientsResponse.add(dto);
            }
            return clientsResponse;
        } catch (Exception error) {
            error.printStackTrace();
            throw new RuntimeException(error.getMessage());
        }
    }

    public Optional<Client> listById(UUID id) {
        return this.repository.findById(id);
    }

    public ArrayList<ClientResponseDTO> listByAge(Integer age) {
        ArrayList<ClientResponseDTO> searchedClients = new ArrayList<>();
        Iterable<Client> clients = this.repository.findAll();
        for(Client client : clients) {
            if (client.getIdade() == age) {
                searchedClients.add(new ClientResponseDTO(client.getNome(), client.getIdade(), client.getProfissao()));
            }
        }

        return searchedClients;
    }


    public String update(String id, Client updatedClient) {
        UUID uuid = UUID.fromString(id);
        Optional<Client> existingClientOptional = this.repository.findById(uuid);

        if (existingClientOptional.isPresent()) {
            // updatedClient.setId(uuid);
            String updatedName = updatedClient.getNome() == null ? existingClientOptional.get().getNome() : updatedClient.getNome();
            int updatedAge = updatedClient.getIdade() == 0 ? existingClientOptional.get().getIdade() : updatedClient.getIdade();
            String updatedProfession = updatedClient.getProfissao() == null ? existingClientOptional.get().getProfissao() : updatedClient.getProfissao();

            this.repository.save(new Client(uuid, updatedName, updatedAge, updatedProfession));
            return "Cliente atualizado com sucesso.";
        }

        return "Cliente " + id + " não encontrado.";
    }

    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        List<UUID> listUuid = Collections.singletonList(uuid);
        this.repository.deleteAllById(listUuid);
    }
}