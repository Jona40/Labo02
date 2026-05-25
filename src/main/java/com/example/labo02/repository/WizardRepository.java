package com.example.labo02.repository;

import com.example.labo02.domain.model.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {
    List<Wizard> findByIsDeatheaterTrue();
    Wizard findByPatronusIgnoreCase(String patronus);
}