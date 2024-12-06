package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entites.Bloc;
import tn.esprit.tpfoyer.sevices.interfaces.IBlocService;

import java.util.List;
//dispatcher servlet
//front
//
@Tag(name = "Gestion Bloc")
@RestController
@RequestMapping("api/bloc")
public class BlocController {
    @Autowired
    //@Qualifier("blocServiceImpl2")
    IBlocService blocServiceImpl;

    @Operation(summary = "get all entities", description = "get all entities")
    @GetMapping("get-all")
    public List<Bloc> readAll(){
        return blocServiceImpl.readAll();
    }
    @Operation(summary = "get an entity by id" , description = "get an entity by id")
    @GetMapping("get-by-id/{id}")
    Bloc readById(@PathVariable int id){
        return blocServiceImpl.readById(id);
    }
    @PostMapping("add")
    @Operation(summary = "add an entity" , description = "add an entity")
    Bloc create(@RequestBody Bloc bloc){
        return blocServiceImpl.create(bloc);
    }
    @PutMapping("update")
    @Operation(summary ="update an entity" ,description = "update an entity")
    Bloc update (@RequestBody Bloc bloc){
        return blocServiceImpl.update(bloc);
    }
    @DeleteMapping("delete/{id}")
    @Operation(summary ="delete an entity" , description = "delete an entity")
    Boolean delete(@PathVariable int id){
        return blocServiceImpl.delete(id);
    }
    @GetMapping("by-nom-uni")
    public List<Bloc> getBlocByNomUniversite(@RequestParam String nom){
       return blocServiceImpl.getBlocByNomUniversite(nom);
    }
    @PostMapping("affecterChambresABloc")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @RequestParam long idBloc){
        System.err.println("Controller : " +numChambre.toString() +"      "+ idBloc);
        return blocServiceImpl.affecterChambresABloc(numChambre,idBloc);
    }



}
