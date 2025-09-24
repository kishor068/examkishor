package com.example.controller;

import com.example.entity.EntityKishor;
import com.example.repository.RepositoryKishor;
import com.example.service.ServiceKishor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/user")
@Slf4j
public class ControllerKishor {

    @Autowired
    private RepositoryKishor repositoryKishor;
    @Autowired
    private ServiceKishor serviceKishor;

    @PostMapping("/adduser")
    public ResponseEntity<?> addUserKishor(@RequestBody EntityKishor entityKishor) throws Exception{
        try {
            log.info("test");
            EntityKishor e = serviceKishor.createUserKishor(entityKishor);
            return ResponseEntity.ok(e);
        }catch (Exception ex){
            log.error("Error");
            return ResponseEntity.status(401).body("Error");
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findUserByIdKishor(@PathVariable Long id){
        try{
            return ResponseEntity.ok(serviceKishor.findUserByIdKishor(id));
        }catch (Exception ex){
            return ResponseEntity.status(401).body("Sama id koda");
        }
    }



}
