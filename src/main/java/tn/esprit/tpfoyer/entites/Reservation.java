package tn.esprit.tpfoyer.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = false)
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Reservation {
    @Id
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //@Setter(AccessLevel.NONE)
    String idResevation ;
    Date anneeUniversitaire;
    boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Etudiant> etudiants;
}
