package com.impactit.ihotel.domains.guests.domain.service;

import com.impactit.ihotel.domains.guests.domain.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    List<Client> getAll();

    Page<Client> getAll(Pageable pageable);

    Client getById(Long StudentId);


    Client create(Client student);

    Client update(Long studentId, Client student);

    ResponseEntity<?> delete(Long studentId);
}