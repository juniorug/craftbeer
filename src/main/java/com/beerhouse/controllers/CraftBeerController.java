package com.beerhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.models.CraftBeer;
import com.beerhouse.services.CraftBeerService;

@RestController
@RequestMapping(path="/craft-beers")
public class CraftBeerController {

    @Autowired
    private CraftBeerService craftBeerService;
    
    @PostMapping
    public ResponseEntity<CraftBeer> save(@RequestBody CraftBeer craftBeer) {
        craftBeerService.save(craftBeer);
        return new ResponseEntity<>(craftBeer, HttpStatus.CREATED);
    }
    
    @GetMapping
    public String printHello() {
        return "Hello Springfield!";
    }
}
