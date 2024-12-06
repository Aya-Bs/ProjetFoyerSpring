package tn.esprit.tpfoyer.entites;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@Entity// correspondance entre classe et table
@Table(name="T_Etudiant")

public class User  {
    @Id
    @GeneratedValue
    @Column(name="etd_id")//faire la correspondance entre les att et les colonnes
    private int id;
    @Column(name="etd_nom")//par défaut : nom = nom att ; nulable = true ; unique = false
    private String nom;
    @Column(name="etd_prenom")
    private String prenom;
}
