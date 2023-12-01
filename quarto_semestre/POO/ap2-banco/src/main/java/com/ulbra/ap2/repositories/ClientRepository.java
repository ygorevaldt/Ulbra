package com.ulbra.ap2.repositories;

import com.ulbra.ap2.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {
}
