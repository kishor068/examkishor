package com.example.service;

import com.example.entity.EntityKishor;
import com.example.repository.RepositoryKishor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
public class ServiceKishor {

    @Autowired
    private RepositoryKishor repositoryKishor;
    public EntityKishor createUserKishor(EntityKishor loginEntity)
    {
        return repositoryKishor.save(loginEntity);
    }

    public ResponseEntity<EntityKishor> findUserByIdKishor(Long id){
        return ResponseEntity.ok(repositoryKishor.findById(id).get());
    }
}
