package com.example.labo02.services;

import com.example.labo02.domain.model.Wizard;
import java.util.List;
import java.util.UUID;

public interface WizardService {
    Wizard createWizard(Wizard wizard);
    List<Wizard> getAllWizards();
    List<Wizard> getDeathEaters();
    Wizard updateWizard(UUID id, Wizard wizard);
    List<Wizard> getByPatronus(String patronus);
    void deleteWizard(UUID id);
}