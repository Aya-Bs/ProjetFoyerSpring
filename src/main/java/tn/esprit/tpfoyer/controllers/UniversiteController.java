package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entites.Universite;
import tn.esprit.tpfoyer.sevices.interfaces.IUniversiteService;

import java.util.List;

@Tag(name = "Gestion Universite")
@RestController
@RequestMapping("api/universite")
public class UniversiteController {
    @Autowired
    IUniversiteService universiteService;

    @GetMapping("get-all")
    @Operation(summary = "get all entities", description = "get all entities")
    public List<Universite> readAll(){
        return universiteService.readAll();
    }
    @GetMapping("get-by-id/{id}")
    @Operation(summary = "get an entity by id" , description = "get an entity by id")
    Universite readById(@PathVariable int id){
        return universiteService.readById(id);
    }
    @PostMapping("add")
    @Operation(summary = "add an entity" , description = "add an entity")
    Universite create(@RequestBody Universite universite){
        return universiteService.create(universite);
    }
    @PutMapping("update")
    @Operation(summary ="update an entity" ,description = "update an entity")
    Universite update (@RequestBody Universite universite){
        return universiteService.update(universite);
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary ="delete an entity" , description = "delete an entity")
    Boolean delete(@PathVariable int id){
        return universiteService.delete(id);
    }

    @PostMapping("desaffecterFoyer")
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
       return this.universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
    @PostMapping("affecterFoyer")
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite){
        return this.universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

}
