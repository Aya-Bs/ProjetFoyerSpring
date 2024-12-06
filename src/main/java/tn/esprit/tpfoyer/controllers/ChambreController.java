package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Chambre;
import tn.esprit.tpfoyer.entites.TypeChambre;
import tn.esprit.tpfoyer.sevices.interfaces.IChambreService;

import java.util.List;
@Tag(name = "Gestion Chambre")
@RestController
@RequestMapping("api/chambre")
public class ChambreController {
    @Autowired
    IChambreService chambreService;

    @Operation(summary = "get all entities", description = "get all entities")
    @GetMapping("get-all")
    public List<Chambre> readAll(){
        return chambreService.readAll();
    }
    @GetMapping("get-by-id/{id}")
    @Operation(summary = "get an entity by id" , description = "get an entity by id")
    Chambre readById(@PathVariable int id){
        return chambreService.readById(id);
    }
    @PostMapping("add")
    @Operation(summary = "add an entity" , description = "add an entity")
    Chambre create(@RequestBody Chambre chambre){

        return chambreService.create(chambre);
    }
    @PutMapping("update")
    @Operation(summary ="update an entity" ,description = "update an entity")
    Chambre update (@RequestBody Chambre chambre){

        return chambreService.update(chambre);
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary ="delete an entity" , description = "delete an entity")
    Boolean delete(@PathVariable int id){

        return chambreService.delete(id);
    }
    public int getReservationNbr(){
        return chambreService.getReservationNbr();
    }
    @Operation(summary = "get all chambres by bloc", description = "get all entities")
    @GetMapping("ChambreByBloc")

    public List<Chambre> findChambreByBloc(long idBloc){
        return chambreService.findChambresByBloc(idBloc).stream().toList();
    }
    @Operation(summary = "get all chambres par uni", description = "get all chambres par uni")
    @GetMapping("ChambresParNomUniversite")
    public List<Chambre> getChambresParNomUniversite(String nomUniversite){
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }
    @Operation(summary = "get all chambres par uni", description = "get all chambres par uni")
    @GetMapping("ChambresParBlocEtTypeKeyword")
    public List<Chambre> getChambresParBlocEtTypeKeyword (long idBloc, TypeChambre typeC) {
        return chambreService.getChambresParBlocEtTypeKeyword(idBloc,typeC);
    }
    @Operation(summary = "get all chambres par uni", description = "get all chambres par uni")
    @GetMapping("ChambresParBlocEtTypeQuery")
    public List<Chambre> getParBlocEtType (long idBloc, TypeChambre typeC) {
        return chambreService.getParBlocEtType(idBloc,typeC);
    }

}
