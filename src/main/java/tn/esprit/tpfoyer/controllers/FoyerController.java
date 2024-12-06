package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.entites.Foyer;
import tn.esprit.tpfoyer.sevices.interfaces.IFoyerService;

import java.util.List;
@Tag(name = "Gestion Foyer")
@RestController
@RequestMapping("api/foyer")
public class FoyerController {
    @Autowired
    IFoyerService foyerService;

    @GetMapping("get-all")
    @Operation(summary = "get all entities",description = "get all entities")
    public List<Foyer> readAll(){
        return foyerService.readAll();
    }

    @GetMapping("get-by-id/{id}")
    @Operation(summary = "get an entity by id" ,description = "get an entity by id")
    Foyer readById(@PathVariable int id){
        return foyerService.readById(id);
    }

    @PostMapping("add")
    @Operation(summary = "add an entity" ,description = "add an entity")
    Foyer create(@RequestBody Foyer foyer){
        return foyerService.create(foyer);
    }

    @PutMapping("update")
    @Operation(summary ="update an entity" ,description = "update an entity")
    Foyer update (@RequestBody Foyer foyer){

        return foyerService.update(foyer);
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary ="delete an entity" ,description = "delete an entity")
    Boolean delete(@PathVariable int id){

        return foyerService.delete(id);
    }

    @PostMapping("ajouterFoyerEtAffecterAUniversite")
    @Operation(summary = "ajouter Foyer Et Affecter Universite" ,description = "ajouter Foyer Et Affecter Universite")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, long idUniversite){
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    }


}
