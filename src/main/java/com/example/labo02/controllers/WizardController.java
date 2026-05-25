package com.example.labo02.controllers;

import com.example.labo02.domain.model.Wizard;
import com.example.labo02.services.WizardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wizards")
@AllArgsConstructor
public class WizardController {

    private final WizardService wizardService;

    @PostMapping
    public ResponseEntity<Wizard> createWizard(@RequestBody Wizard wizard) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wizardService.createWizard(wizard));
    }

    @GetMapping
    public ResponseEntity<List<Wizard>> getAllWizards() {
        return ResponseEntity.ok(wizardService.getAllWizards());
    }

    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeathEaters() {
        return ResponseEntity.ok(wizardService.getDeathEaters());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(@PathVariable UUID id, @RequestBody Wizard wizard) {
        return ResponseEntity.ok(wizardService.updateWizard(id, wizard));
    }

    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getByPatronus(@PathVariable String patronus) {
        return ResponseEntity.ok(wizardService.getByPatronus(patronus));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWizard(@PathVariable UUID id) {
        wizardService.deleteWizard(id);
        return ResponseEntity.noContent().build();
    }
}