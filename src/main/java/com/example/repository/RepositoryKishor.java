package com.example.repository;

import com.example.entity.EntityKishor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryKishor extends JpaRepository<EntityKishor,Long> {

}
