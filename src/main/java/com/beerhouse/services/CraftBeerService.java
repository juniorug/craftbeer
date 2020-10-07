package com.beerhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.beerhouse.models.CraftBeer;

@Component("CraftBeerService")
public interface CraftBeerService {

    void save(CraftBeer CraftBeer);

    List<CraftBeer> getAll();

    CraftBeer findById(Long id);

    List<CraftBeer> findByName(String name);

    CraftBeer update(Long id, CraftBeer CraftBeer);

    void deleteById(Long id);
    
    void deleteAll();

}
