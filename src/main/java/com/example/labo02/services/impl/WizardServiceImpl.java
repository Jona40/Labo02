package com.example.labo02.services.impl;

import com.example.labo02.domain.model.Wizard;
import com.example.labo02.repository.WizardRepository;
import com.example.labo02.services.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;

    @Override
    public Wizard createWizard(Wizard wizard) {
        return wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    @Override
    public List<Wizard> getDeathEaters() {
        return wizardRepository.findByIsDeatheaterTrue();
    }

    @Override
    public Wizard updateWizard(UUID id, Wizard wizard) {
        Wizard existing = wizardRepository.findById(id).orElseThrow();
        existing.setName(wizard.getName());
        existing.setHouse(wizard.getHouse());
        existing.setPatronus(wizard.getPatronus());
        existing.setIsDeatheater(wizard.getIsDeatheater());
        return wizardRepository.save(existing);
    }

    @Override
    public Wizard getByPatronus(String patronus) {
        return wizardRepository.findByPatronusIgnoreCase(patronus);
    }

    @Override
    public void deleteWizard(UUID id) {
        wizardRepository.deleteById(id);
    }
}