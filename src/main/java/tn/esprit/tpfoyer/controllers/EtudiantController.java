package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entites.Etudiant;
import tn.esprit.tpfoyer.sevices.interfaces.IEtudiantService;

import java.util.List;

@Tag(name = "Gestion Etudiant")
@RestController
@RequestMapping("api/etudiant")
public class EtudiantController{
    @Autowired
    IEtudiantService etudiantService;


    @GetMapping("get-all")
    @Operation(summary = "get all entities", description = "get all entities")
    public List<Etudiant> readAll(){
        return etudiantService.readAll();
    }
    @GetMapping("get-by-id/{id}")
    @Operation(summary = "get an entity by id" , description = "get an entity by id")
    Etudiant readById(@PathVariable int id){
        return etudiantService.readById(id);
    }

    @PostMapping("add")
    @Operation(summary = "add an entity" ,description = "add an entity")
    Etudiant create(@RequestBody Etudiant etudiant){

        return etudiantService.create(etudiant);
    }
    @PutMapping("update")
    @Operation(summary ="update an entity" ,description = "update an entity")
    Etudiant update (@RequestBody Etudiant etudiant){

        return etudiantService.update(etudiant);
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary ="delete an entity" , description = "delete an entity")
    Boolean delete(@PathVariable int id){

        return etudiantService.delete(id);
    }

}
