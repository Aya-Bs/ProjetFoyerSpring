package tn.esprit.tpfoyer.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
     long idFoyer;
     String nomFoyer;
     long capaciteFoyer;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude

    @OneToMany (mappedBy = "foyer", cascade = CascadeType.PERSIST)
    @JsonManagedReference

     Set<Bloc> blocs;
    @ToString.Exclude
    @OneToOne(mappedBy = "foyer")

    Universite universite;

}
