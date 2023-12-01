package com.apdois.app.external.database.client.repository;

import com.apdois.app.external.database.client.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public interface ClientMySqlRepository extends CrudRepository<Client, String>{

}
