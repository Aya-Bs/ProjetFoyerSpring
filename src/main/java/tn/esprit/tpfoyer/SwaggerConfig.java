package tn.esprit.tpfoyer;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi gestionBlocApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Bloc") // Group name for dropdown
                .pathsToMatch("/api/bloc/**") // Define paths handled by this group
                .build();
    }

    @Bean
    public GroupedOpenApi gestionFoyerApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Foyer")
                .pathsToMatch("/api/foyer/**")
                .build();
    }
    @Bean
    public GroupedOpenApi gestionUniversiteApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Universite")
                .pathsToMatch("/api/universite/**")
                .build();
    }
    @Bean
    public GroupedOpenApi gestionChambreApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Chambre")
                .pathsToMatch("/api/chambre/**")
                .build();
    }
    @Bean
    public GroupedOpenApi gestionEtudiantApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Etudiant")
                .pathsToMatch("/api/etudiant/**")
                .build();
    }
    @Bean
    public GroupedOpenApi gestionReservationApi() {
        return GroupedOpenApi.builder()
                .group("Gestion Reservation")
                .pathsToMatch("/api/reservation/**")
                .build();
    }
}
