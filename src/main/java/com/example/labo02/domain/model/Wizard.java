package com.example.labo02.domain.model;

import jakarta.persistence.*;
        import lombok.*;
        import java.util.UUID;

@Entity
@Table(name = "wizards")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String house;
    private String patronus;

    @Column(name = "is_deatheater")
    private Boolean isDeatheater;
}