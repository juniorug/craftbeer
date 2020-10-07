package com.beerhouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.models.CraftBeer;
import com.beerhouse.services.CraftBeerService;

@RestController
@RequestMapping(path = "/craft-beers")
public class CraftBeerController {

    @Autowired
    private CraftBeerService craftBeerService;

    @PostMapping
    public ResponseEntity<CraftBeer> save(@RequestBody CraftBeer craftBeer) {
        craftBeerService.save(craftBeer);
        return new ResponseEntity<>(craftBeer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CraftBeer>> getAll() {
        System.out.println("getAll called!22");
        try {
            List<CraftBeer> craftBeers = craftBeerService.getAll();
            if (craftBeers.isEmpty()) {
                System.out.println("craftBeers.isEmpty()");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("craftBeers.is not empty()");
            return new ResponseEntity<>(craftBeers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CraftBeer> getCraftBeerById(@PathVariable("id") long id) {
        System.out.println("getCraftBeerById called!22");  
      CraftBeer CraftBeerData = craftBeerService.findById(id);

      if (null != CraftBeerData) {
          System.out.println("craftBeers.is not empty()");
        return new ResponseEntity<>(CraftBeerData, HttpStatus.OK);
      } else {
          System.out.println("craftBeers.isEmpty()");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    
}
