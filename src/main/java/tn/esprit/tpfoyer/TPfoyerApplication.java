package tn.esprit.tpfoyer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.tpfoyer.controllers.BlocController;
import tn.esprit.tpfoyer.controllers.ChambreController;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Chambre;
import tn.esprit.tpfoyer.entites.Foyer;
import tn.esprit.tpfoyer.entites.Universite;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "tpfoyer", description = "gestion des foyer des univ", contact = @Contact(name = "4TWIN7", url = "http://google.com", email = "aya.boukhris@esprit.tn")))

public class TPfoyerApplication {

    public static void main(String[] args) {

       // SpringApplication.run(TPfoyerApplication.class, args);
        ApplicationContext context = SpringApplication.run(TPfoyerApplication.class, args);

        // User user = new User();
        BlocController b = context.getBean(BlocController.class);
        //Bloc result = b.getBlocByNomUniversite("Esprit");
        //System.out.println(result);
        ChambreController c = context.getBean(ChambreController.class);
        int nbr = c.getReservationNbr();
        System.out.println(nbr);

    }
}
