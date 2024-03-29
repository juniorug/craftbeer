package com.beerhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.models.CraftBeer;
import com.beerhouse.services.CraftBeerService;

@RestController
@RequestMapping(path = "/craft-beers", produces = "application/json")
public class CraftBeerController {

    @Autowired
    private CraftBeerService craftBeerService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CraftBeer> save(@RequestBody CraftBeer craftBeer) {
        try {
            craftBeerService.save(craftBeer);
            return new ResponseEntity<>(craftBeer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<CraftBeer>> getAll() {
        try {
            List<CraftBeer> craftBeers = craftBeerService.getAll();
            if (craftBeers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(craftBeers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CraftBeer> getCraftBeerById(@PathVariable("id") long id) {
        try {
            CraftBeer craftBeerData = craftBeerService.findById(id);
            if (null != craftBeerData) {
                return new ResponseEntity<>(craftBeerData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CraftBeer>> findByName(@PathVariable("name") String name) {
        try {
            List<CraftBeer> craftBeerData = craftBeerService.findByName(name);
            if (craftBeerData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(craftBeerData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CraftBeer> updateCraftBeer(@PathVariable("id") long id, @RequestBody CraftBeer craftBeer) {
        try {
            CraftBeer craftBeerData = craftBeerService.update(id, craftBeer);
            if (null != craftBeerData) {
                return new ResponseEntity<>(craftBeerData, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCraftBeer(@PathVariable("id") long id) {
        try {
            craftBeerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllCraftBeer() {
        try {
            craftBeerService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
