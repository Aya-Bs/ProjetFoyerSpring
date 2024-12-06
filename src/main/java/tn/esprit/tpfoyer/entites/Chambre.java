package tn.esprit.tpfoyer.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
     long idChambre ;
     long numeroChambre ;
    @Enumerated(EnumType.STRING)
     TypeChambre typeC;
    @OneToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    Set<Reservation> reservations = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Bloc bloc;
}
